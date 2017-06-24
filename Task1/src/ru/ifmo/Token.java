package ru.ifmo;

/**
 * Created by bigdreamer on 08.05.17.
 */
public enum Token {
    KEYWORD, NAME, LPAREN, RPAREN, COMMA, COLON, SEMICOLON, END, VAR;

    String description() {
        switch (this) {
            case KEYWORD:
                return LexicalAnalyzer.FUNCTION_KEYWORD + " or " + LexicalAnalyzer.PROCEDURE_KEYWORD + " keyword";
            case NAME:
                return "Name declaration";
            case  LPAREN:
                return "(";
            case RPAREN:
                return ")";
            case COMMA:
                return ",";
            case COLON:
                return ":";
            case SEMICOLON:
                return ";";
            case END:
                return "End of file";
            case VAR:
                return "var";
            default:
                throw new AssertionError();
        }
    }
}
