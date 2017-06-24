package antlr_g4;

import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by bigdreamer on 14.06.17.
 */
public class ParserGeneratorHelper extends ANTLRv4ParserBaseListener {
    public final class ParserRuleContext {
        public String arguments;
        public String returnValue;
        public String localVariables;
        public ArrayList<ArrayList< ANTLRv4Parser.ElementContext> > alternatives = new ArrayList<>();
    }

    public HashMap<String, ParserRuleContext> parserRules = new HashMap<>();

    private String argumentContent;
    private ParserRuleContext parserRuleContext;
    private ArrayList<ANTLRv4Parser.ElementContext> parserRuleAlternativeElements = new ArrayList<>();

    @Override
    public void enterParserRuleSpec(ANTLRv4Parser.ParserRuleSpecContext ctx) {
        super.enterParserRuleSpec(ctx);
        parserRuleContext = new ParserRuleContext();
    }

    @Override
    public void exitParserRuleSpec(ANTLRv4Parser.ParserRuleSpecContext ctx) {
        super.exitParserRuleSpec(ctx);
        parserRules.put(ctx.RULE_REF().toString(), parserRuleContext);
    }

    @Override
    public void exitArgActionBlock(ANTLRv4Parser.ArgActionBlockContext ctx) {
        super.exitArgActionBlock(ctx);

        argumentContent = "";
        for (TerminalNode node: ctx.ARGUMENT_CONTENT()) {
            argumentContent += node.getText();
        }
//        System.out.println("argumentContent: " + argumentContent);

        if (ctx.getParent() instanceof ANTLRv4Parser.ParserRuleSpecContext) {
            parserRuleContext.arguments = argumentContent;
        }
    }

    @Override
    public void exitRuleReturns(ANTLRv4Parser.RuleReturnsContext ctx) {
        super.exitRuleReturns(ctx);
        parserRuleContext.returnValue = argumentContent;
    }

    @Override
    public void exitLocalsSpec(ANTLRv4Parser.LocalsSpecContext ctx) {
        super.exitLocalsSpec(ctx);
        parserRuleContext.localVariables = argumentContent;
    }


    @Override
    public void enterAlternative(ANTLRv4Parser.AlternativeContext ctx) {
        super.enterAlternative(ctx);
        parserRuleAlternativeElements.clear();
    }

    @Override
    public void exitAlternative(ANTLRv4Parser.AlternativeContext ctx) {
        super.exitAlternative(ctx);
        parserRuleContext.alternatives.add(new ArrayList<>(parserRuleAlternativeElements));

//        System.out.println(parserRuleAlternativeElements.isEmpty());
    }

    @Override
    public void exitElement(ANTLRv4Parser.ElementContext ctx) {
        super.exitElement(ctx);
        parserRuleAlternativeElements.add(ctx);
//        System.out.println(ctx.getText());
    }
}
