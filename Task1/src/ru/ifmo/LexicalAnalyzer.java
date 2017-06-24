package ru.ifmo;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;

/**
 * Created by bigdreamer on 08.05.17.
 */
public class LexicalAnalyzer {
    final static String FUNCTION_KEYWORD = "function";
    final static String PROCEDURE_KEYWORD = "procedure";
    final static String VAR_KEYWORD = "var";

    private InputStream is;
    private int curChar;
    private int curPos;
    private Token curToken;

    public LexicalAnalyzer(InputStream is) throws ParseException {
        this.is = is;
        curPos = 0;
        nextChar();
    }

    private boolean isBlank(int c) {
        return c == ' ' || c == '\r' || c == '\n' || c == '\t';
    }

    private void nextChar() throws ParseException {
        curPos++;
        try {
            curChar = is.read();
        } catch (IOException e) {
            throw new ParseException(e.getMessage(), curPos);
        }
    }

    public void nextToken() throws ParseException {
        while (isBlank(curChar)) {
            nextChar();
        }
        switch (curChar) {
            case '(':
                nextChar();
                curToken = Token.LPAREN;
                break;
            case ')':
                nextChar();
                curToken = Token.RPAREN;
                break;
            case ':':
                nextChar();
                curToken = Token.COLON;
                break;
            case ';':
                nextChar();
                curToken = Token.SEMICOLON;
                break;
            case ',':
                nextChar();
                curToken = Token.COMMA;
                break;
            case -1:
                curToken = Token.END;
                break;
            default:
                if (!Character.isLetter(curChar)) {
                    throw new ParseException("Illegal character " + (char) curChar, curPos);
                }

                String s = "";
                while (Character.isLetter(curChar)) {
                    s += (char) curChar;
                    nextChar();
                }
                curToken = (FUNCTION_KEYWORD.equals(s) || PROCEDURE_KEYWORD.equals(s)) ? Token.KEYWORD
                        : (VAR_KEYWORD.equals(s) ? Token.VAR : Token.NAME);
        }
    }

    public Token curToken() {
        return curToken;
    }

    public int curPos() {
        return curPos;
    }
}
