package ru.ifmo;

import java.io.InputStream;
import java.text.ParseException;

/**
 * Created by bigdreamer on 08.05.17.
 */
public class Parser {
    private LexicalAnalyzer lex;

    private void expect(Token... expectedTokens) throws ParseException {
        for (Token token: expectedTokens) {
            if (lex.curToken() != token) {
                throw new ParseException(token.description() + " expected at position", lex.curPos());
            }
            lex.nextToken();
        }
    }

    private Tree unexpectedToken() throws ParseException {
        throw new ParseException("Unexpected token " + lex.curToken().description() + " at position", lex.curPos());
    }

    private Tree S() throws ParseException {
        expect(Token.KEYWORD, Token.NAME, Token.LPAREN);

        Tree arguments = A();

        expect(Token.RPAREN, Token.COLON, Token.NAME, Token.SEMICOLON);

        if (lex.curToken() != Token.END) {
            throw new ParseException(Token.END.description() + " expected at position", lex.curPos());
        }

        return new Tree("S", new Tree("k"), new Tree("v"), new Tree("("), arguments, new Tree(")"),
                new Tree(":"), new Tree("v"), new Tree(";"));
    }

    private Tree A() throws ParseException {
        switch (lex.curToken()) {
            case NAME:
            case VAR:
                return new Tree("A", B());
            case RPAREN:
                return new Tree("A");
            default:
                return unexpectedToken();
        }
    }

    private Tree B() throws ParseException {
        if (lex.curToken() == Token.VAR) {
            lex.nextToken();
        }
        expect(Token.NAME, Token.COLON, Token.NAME);

        Tree cont = BPrime();

        return new Tree("B", new Tree("v"), new Tree(":"), new Tree("v"), cont);
    }

    private Tree BPrime() throws ParseException {
        switch (lex.curToken()) {
            case COMMA:
                lex.nextToken();
                return new Tree("B'", B());
            case RPAREN:
                return new Tree("B'");
            default:
                return unexpectedToken();
        }
    }

    public Tree parse(InputStream is) throws ParseException {
        lex = new LexicalAnalyzer(is);
        lex.nextToken();
        return S();
    }
}
