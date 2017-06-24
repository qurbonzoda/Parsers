package antlr_g4;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by bigdreamer on 14.06.17.
 */
public class LexerGeneratorHelper extends ANTLRv4ParserBaseListener {
    public HashMap<String, ArrayList<String>> lexerRules = new HashMap<>();
    private ArrayList<String> lexerRuleAlt = new ArrayList<>();
    private ArrayList<String> lexerRuleAltTerminals = new ArrayList<>();

    @Override
    public void enterLexerRuleSpec(ANTLRv4Parser.LexerRuleSpecContext ctx) {
        super.enterLexerRuleSpec(ctx);
        lexerRuleAlt.clear();
    }

    @Override
    public void exitLexerRuleSpec(ANTLRv4Parser.LexerRuleSpecContext ctx) {
        super.exitLexerRuleSpec(ctx);
        lexerRules.put(ctx.TOKEN_REF().getText(), lexerRuleAlt);
    }

    @Override
    public void enterLexerAlt(ANTLRv4Parser.LexerAltContext ctx) {
        super.enterLexerAlt(ctx);
        lexerRuleAltTerminals.clear();
    }

    @Override
    public void exitLexerAlt(ANTLRv4Parser.LexerAltContext ctx) {
        super.exitLexerAlt(ctx);
        lexerRuleAlt.add(lexerRuleAltTerminals.get(0));
    }

    @Override
    public void exitTerminal(ANTLRv4Parser.TerminalContext ctx) {
        super.exitTerminal(ctx);
        lexerRuleAltTerminals.add(ctx.getText());

        if (!(ctx.getParent() instanceof ANTLRv4Parser.LexerAtomContext) && ctx.STRING_LITERAL() != null) {
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(ctx.getText());
            lexerRules.put(ctx.getText(), arrayList);
//            System.out.println("terminal: " + ctx.getText());
        }
    }
}
