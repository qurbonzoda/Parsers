package task3;

import antlr_g4.ANTLRv4Lexer;
import antlr_g4.ANTLRv4Parser;
import antlr_g4.LexerGeneratorHelper;
import antlr_g4.ParserGeneratorHelper;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * Created by bigdreamer on 14.06.17.
 */
public class Task3 {
    final static String secondTaskGrammar =
                    "grammar FunctionHeader;\n" +
                    "header              :  KEYWORD NAME '(' argList ')' ':' NAME ';' ;\n" +
                    "argList             :  nonEmptyArgList\n" +
                    "                    |  ;\n" +
                    "nonEmptyArgList     :  NAME ':' NAME commaNonEmptyArgList ;\n" +
                    "commaNonEmptyArgList :  ',' nonEmptyArgList commaNonEmptyArgList\n" +
                    "                    |  ;\n" +
                    "KEYWORD             :  'function' | 'procedure' ;\n";

    final static String[] secondTaskTests = {
            "function f(a : a, b : b): c;",
            "function f(): void;",
            "procedure sadsad(das: sads): aadjl;",
            "function   askadr (tyn: saj, sAODKA   : saklj, kjKJyty:    dfdfds) : ewewe;",
            "procedure   sadPooPsad \r  \t \n  ( \n sd \r : dstf \t , a:b):x\t;"
    };

    final static String thirdTaskGrammar =
            "grammar Prefix;\n" +
            "start returns [String value]\n" +
            "    :   p=program {$value = String.format(\"begin%s\\nend.\", $p.value);}\n" +
            "    ;\n" +
            "program returns [String value = \"\"]\n" +
            "    :   np=nonEmptyProgram {$value += String.format(\"\\n%s\", $np.value);}\n" +
            "    | ;\n" +
            "nonEmptyProgram returns [String value = \"\"]\n" +
            "    :   act=action p=program {$value += String.format(\"\\n%s\\n%s\", $act.value, $p.value);}" +
            "    ;\n" +
            "action returns [String value = \"\\t\"]\n" +
            "    :   a=assign {$value += $a.value;}\n" +
            "    |   p=print {$value += $p.value;}\n" +
            "    |   e=conditional {$value += $e.value;}\n" +
            "    ;\n" +
            "conditional returns [String value]\n" +
            "    :   'if' e=expression act=action {$value = String.format(\"if (%s) then\\n\\t%s\", $e.value, $act.value);}\n" +
            "    ;\n" +
            "assign returns [String value]\n" +
            "    :   '=' var=NAME e=expression {$value = String.format(\"%s = %s;\", $var.text, $e.value);}\n" +
            "    ;\n" +
            "print returns [String value]\n" +
            "    :   'print' e=expression {$value = String.format(\"writeln(%s);\", $e.value);}\n" +
            "    ;\n" +
            "expression returns [String value]\n" +
            "    :   '+' e1=expression e2=expression {$value = String.format(\"(%s + %s)\", $e1.value, $e2.value);}\n" +
            "    |   '-' e1=expression e2=expression {$value = String.format(\"(%s - %s)\", $e1.value, $e2.value);}\n" +
            "    |   '*' e1=expression e2=expression {$value = String.format(\"%s * %s\", $e1.value, $e2.value);}\n" +
            "    |   '/' e1=expression e2=expression {$value = String.format(\"(%s / %s)\", $e1.value, $e2.value);}\n" +
            "    |   n=NUMBER {$value = $n.text;}\n" +
            "    |   var=NAME {$value = $var.text;}\n" +
            "    |   b=BOOL {$value = $b.text;}\n" +
            "    |   'and' e1=expression e2=expression {$value = String.format(\"%s and %s\", $e1.value, $e2.value);}\n" +
            "    |   'or' e1=expression e2=expression {$value = String.format(\"(%s or %s)\", $e1.value, $e2.value);}\n" +
            "    |   'not' e=expression {$value = String.format(\"not %s\", $e.value);}\n" +
            "    |   '<' e1=expression e2=expression {$value = String.format(\"%s < %s\", $e1.value, $e2.value);}\n" +
            "    |   '>' e1=expression e2=expression {$value = String.format(\"%s > %s\", $e1.value, $e2.value);}\n" +
            "    |   '>=' e1=expression e2=expression {$value = String.format(\"%s >= %s\", $e1.value, $e2.value);}\n" +
            "    |   '<=' e1=expression e2=expression {$value = String.format(\"%s <= %s\", $e1.value, $e2.value);}\n" +
            "    |   '==' e1=expression e2=expression {$value = String.format(\"%s == %s\", $e1.value, $e2.value);}\n" +
            "    |   '!=' e1=expression e2=expression {$value = String.format(\"%s != %s\", $e1.value, $e2.value);}\n" +
            "    ;\n" +
            "BOOL\n" +
            "    :   'true'\n" +
            "    |   'false'\n" +
            "    ;\n";

    final static String[] thirdTaskTests = {
            "if > 2 3 print 3 if > 4 - 7 2 print + 3 4",
            "= a 42 if == a 42 print 42 = a 1 = b true if >= 0 a print != true b print != false b"
    };

    public static void main(String[] args) throws IOException {
//        for (String secondTaskTest: secondTaskTests) {
//            test(secondTaskGrammar, secondTaskTest);
//        }
        for (String thirdTaskTest: thirdTaskTests) {
            test(thirdTaskGrammar, thirdTaskTest);
        }
    }

    private static void test(String grammar, String instance) {
        ANTLRInputStream in = new ANTLRInputStream(grammar);
        ANTLRv4Lexer lexer = new ANTLRv4Lexer(in);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ANTLRv4Parser parser = new ANTLRv4Parser(tokens);
        parser.setBuildParseTree(true);

        LexerGeneratorHelper lexerGeneratorHelper = new LexerGeneratorHelper();
        ParserGeneratorHelper parserGeneratorHelper = new ParserGeneratorHelper();

        ANTLRv4Parser.GrammarSpecContext tree = parser.grammarSpec();

        ParseTreeWalker.DEFAULT.walk(lexerGeneratorHelper, tree);
        ParseTreeWalker.DEFAULT.walk(parserGeneratorHelper, tree);

        new LexerGenerator(lexerGeneratorHelper.lexerRules).generateLexer();
        new ParserGenerator(parserGeneratorHelper.parserRules).generateParser();

//        System.out.println(lexerGeneratorHelper.lexerRules);
//        System.out.println(parserGeneratorHelper.parserRules);
//
//        GeneratedParser generatedParser = new GeneratedParser(
//                new ByteArrayInputStream(instance.getBytes(StandardCharsets.UTF_8)));
//
//        generatedParser.header();

//        GeneratedLexer generatedLexer = new GeneratedLexer(
//                new ByteArrayInputStream(instance.getBytes(StandardCharsets.UTF_8)));
//
//        while (!"END".equals(generatedLexer.nextToken())) {
//            System.out.println(generatedLexer.curToken());
//        }
    }
}
