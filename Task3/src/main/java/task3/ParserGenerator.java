package task3;

import antlr_g4.ANTLRv4Parser;
import antlr_g4.ParserGeneratorHelper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.*;

/**
 * Created by bigdreamer on 15.06.17.
 */
public class ParserGenerator {
    private final String EPS = "EPS";

    private HashMap<String, ParserGeneratorHelper.ParserRuleContext> parserRules;
    private HashMap<String, HashSet<String>> ruleFirst;
    private HashMap<String, ArrayList< HashSet<String> >> ruleAlternativeFirst;

    public ParserGenerator(HashMap<String, ParserGeneratorHelper.ParserRuleContext> parserRules) {
        this.parserRules = parserRules;
        ruleFirst = new HashMap<>();
        ruleAlternativeFirst = new HashMap<>();

        for (Map.Entry<String, ParserGeneratorHelper.ParserRuleContext> entry: this.parserRules.entrySet()) {
            ruleFirst.put(entry.getKey(), new HashSet<String>());
            ruleAlternativeFirst.put(entry.getKey(), new ArrayList<HashSet<String>>());
            for (int i = 0; i < entry.getValue().alternatives.size(); i++) {
                ruleAlternativeFirst.get(entry.getKey()).add(new HashSet<String>());
            }
        }
    }

    public void generateParser() {
        buildFirst();

//        for (Map.Entry<String, ParserGeneratorHelper.ParserRuleContext> entry : parserRules.entrySet()) {
//            String ruleName = entry.getKey();
//            System.out.println(ruleName);
//            for (int i = 0; i < entry.getValue().alternatives.size(); i++) {
//                System.out.println(ruleAlternativeFirst.get(ruleName).get(i));
//            }
//        }

        String prototypePath = "/Users/bigdreamer/Programming/Parsers/Task3/src/main/java/" +
                "prototypes/GeneratedParserPrototype.txt";
        try (Scanner scanner = new Scanner(new File(prototypePath))) {
            String newParser = scanner.useDelimiter("\\Z").next().replace("%%INSERT_RULES%%", rulesDefinition());

            String path = "/Users/bigdreamer/Programming/Parsers/Task3/src/main/java/generated/GeneratedParser.java";
            try (PrintWriter parserWriter = new PrintWriter(new FileOutputStream(path))) {
                parserWriter.print(newParser);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private String rulesDefinition() {
        String definition = "";
        for (String ruleName: parserRules.keySet()) {
            definition += ruleDefinition(ruleName) + "\n";
        }
        return definition;
    }

    private String ruleDefinition(String ruleName) {
        ParserGeneratorHelper.ParserRuleContext context = parserRules.get(ruleName);
        HashSet<String> ruleFirst = this.ruleFirst.get(ruleName);
        ArrayList< HashSet<String> > ruleAlternativeFirst = this.ruleAlternativeFirst.get(ruleName);

        String funcHeader = "\tpublic " + funcReturnType(context.returnValue) + " "
                + ruleName + "(" + funcParameters(context.arguments) + ") {\n";

        String funcReturnVariable = "\t\t" + funcReturnVariable(context.returnValue) + ";\n";

        String switchCase = "\t\tswitch (lex.curToken().name) {\n";

        int epsAlternative = -1;
        for (int i = 0; i < context.alternatives.size(); i++) {
            String cases = cases(ruleAlternativeFirst.get(i));
            if (!cases.isEmpty()) {
//                System.out.println();
                switchCase += cases;
                switchCase += handler(context.alternatives.get(i));
                switchCase += "\t\t\t\tbreak;\n";
            }
            if (ruleAlternativeFirst.get(i).contains(EPS)) {
                assert epsAlternative == -1;
                epsAlternative = i;
            }
        }

        switchCase += "\t\t\tdefault:\n";
        if (epsAlternative == -1) {
            switchCase += "\t\t\t\tthrow new IllegalArgumentException(\"unexpected token \" + lex.curToken().name);\n";
        } else {
            switchCase += handler(context.alternatives.get(epsAlternative));
        }
        switchCase += "\t\t}\n";

        String returnStatement = "\t\treturn " + funcReturnValue(context.returnValue) + ";\n";

        return funcHeader + funcReturnVariable + switchCase + returnStatement + "\t}\n";
    }

    private String handler(ArrayList<ANTLRv4Parser.ElementContext> elementContexts) {
        String handler = "\t\t\t\t{\n";
        for (ANTLRv4Parser.ElementContext elementContext: elementContexts) {
//            System.out.println(elementContext.getText());
            handler += labeledElementHandler(elementContext.labeledElement())
                    + atomHandler(elementContext.atom())
                    + actionBlockHandler(elementContext.actionBlock())
                    + "\n";
        }
        return handler + "\t\t\t\t}\n";
    }

    private String actionBlockHandler(ANTLRv4Parser.ActionBlockContext actionBlockContext) {
        if (actionBlockContext == null) { return ""; }
        String actionBlock = actionBlockContext.getText();
        actionBlock = actionBlock.replace('$', ' ');
        actionBlock = actionBlock.replace(".value", "");
        actionBlock = actionBlock.replace(".text", "");
        return "\t\t\t\t" + actionBlock + "\n";
    }

    private String labeledElementHandler(ANTLRv4Parser.LabeledElementContext labeledElementContext) {
        if (labeledElementContext == null) { return ""; }

        String terminal = null;
        if (labeledElementContext.atom().terminal() != null) {
            terminal = labeledElementContext.atom().terminal().getText();
        }

        return "\t\t\t\tString "
                + labeledElementContext.identifier().getText()
                + labeledElementContext.ASSIGN().getText()
                + (terminal != null ? "lex.curToken().text;\n" : "")
                + atomHandler(labeledElementContext.atom());
    }

    private String atomHandler(ANTLRv4Parser.AtomContext atomContext) {
        if (atomContext == null) { return ""; }

        if (atomContext.terminal() != null) {
            String token = atomContext.terminal().getText();
            return "\t\t\t\tif (!\"" + token + "\".equals(lex.curToken().name)) {\n"
                    + "\t\t\t\t\tthrow new IllegalArgumentException(\"expected " + token + ", found \" + lex.curToken().name);\n"
                    + "\t\t\t\t}\n"
                    + "\t\t\t\tlex.nextToken();\n";
        } else if (atomContext.ruleref() != null) {
            String arguments = atomContext.ruleref().argActionBlock() != null
                    ? atomContext.ruleref().argActionBlock().getText() : "";
            return "\t\t\t\t" + atomContext.ruleref().RULE_REF().getText() + "(" + arguments + ");\n";
        }
        assert false;
        return null;
    }

    private String cases(HashSet<String> first) {
        String cases = "";
        for (String token: first) {
            if (!token.equals(EPS)) {
                cases += "\t\t\tcase \"" + token + "\":\n";
            }
        }
        return cases;
    }

    private String funcParameters(String arguments) {
        if (arguments == null) { return ""; }
        return arguments;
    }

    private String funcReturnType(String argumentContent) {
        if (argumentContent == null) { return "void"; }
        String[] split = argumentContent.split(" ");
        return split[0];
    }

    private String funcReturnVariable(String argumentContent) {
        return argumentContent != null ? argumentContent : "";
    }

    private String funcReturnValue(String argumentContent) {
        if (argumentContent == null) { return ""; }
        String[] split = argumentContent.split(" ");
        return split[1];
    }


    private void buildFirst() {
        boolean changed = true;
        while (changed) {
            changed = false;
            for (Map.Entry<String, ParserGeneratorHelper.ParserRuleContext> entry: parserRules.entrySet()) {
                String ruleName = entry.getKey();
                ArrayList< ArrayList<ANTLRv4Parser.ElementContext> > ruleAlternatives = entry.getValue().alternatives;

                for (int i = 0; i < ruleAlternatives.size(); i++) {
                    HashSet<String> ruleAltFirst = ruleAlternativeFirst.get(ruleName).get(i);

                    if (ruleAlternatives.get(i).isEmpty()) {
                        ruleAltFirst.add(EPS);
                    }

                    for (ANTLRv4Parser.ElementContext elementContext: ruleAlternatives.get(i)) {
                        HashSet<String> elementFirst = elementFirst(elementContext);
                        if (elementFirst == null) {
                            break;
                        }
                        ruleAltFirst.addAll(elementFirst);
                        if (!elementFirst.contains(EPS)) {
                            break;
                        }
                    }

                    changed |= ruleFirst.get(ruleName).addAll(ruleAltFirst);
                }
            }
        }
    }

    private HashSet<String> elementFirst(ANTLRv4Parser.ElementContext elementContext) {
        if (elementContext.labeledElement() != null) {
            return labeledElementFirst(elementContext.labeledElement());
        } else if (elementContext.atom() != null) {
            return atomFirst(elementContext.atom());
        } else if (elementContext.actionBlock() != null) {
            return new HashSet<>();
        }

        assert false;
        return null;
    }

    private HashSet<String> labeledElementFirst(ANTLRv4Parser.LabeledElementContext labeledElementContext) {
        return atomFirst(labeledElementContext.atom());
    }

    private HashSet<String> atomFirst(ANTLRv4Parser.AtomContext atomContext) {
        if (atomContext.terminal() != null) {
            return new HashSet<>(Collections.singletonList(terminalFirst(atomContext.terminal())));
        } else if (atomContext.ruleref() != null) {
            return rulerefFirst(atomContext.ruleref());
        }
        assert false;
        return null;
    }

    private HashSet<String> rulerefFirst(ANTLRv4Parser.RulerefContext rulerefContext) {
        return ruleFirst.get(rulerefContext.RULE_REF().getText());
    }

    private String terminalFirst(ANTLRv4Parser.TerminalContext terminalContext) {
        if (terminalContext.TOKEN_REF() != null) {
            return terminalContext.TOKEN_REF().getText();
        } else if (terminalContext.STRING_LITERAL() != null) {
            return terminalContext.STRING_LITERAL().getText();
        }
        assert false;
        return null;
    }
}
