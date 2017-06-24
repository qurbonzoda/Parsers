package generated;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GeneratedLexer {
    private final InputStream is;
    private int curPos = 0;
    private int peek = ' ';
    private Token lastToken;

    private class Pair {
        String key, value;
        Pair(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    private ArrayList<Pair> lexerRules = new ArrayList<>();

    public GeneratedLexer(InputStream is) {
        this.is = is;

        put("'-'", "^\\-$");
        put("'not'", "^not$");
        put("'+'", "^\\+$");
        put("'*'", "^\\*$");
        put("'and'", "^and$");
        put("'print'", "^print$");
        put("'<='", "^<=$");
        put("'or'", "^or$");
        put("'if'", "^if$");
        put("'>'", "^>$");
        put("'='", "^=$");
        put("'<'", "^<$");
        put("'=='", "^==$");
        put("'>='", "^>=$");
        put("BOOL", "^true$");
        put("BOOL", "^false$");
        put("'!='", "^!=$");
        put("'/'", "^/$");

        put("NAME", "^[a-z_][a-zA-Z0-9_]*$");
        put("NUMBER", "^[0-9]+$");
    }

    private void put(String key, String value) {
        lexerRules.add(new Pair(key, value));
    }

    private boolean shouldSkip(int x) {
        return x == ' ' || x == '\t' || x == '\r' || x == '\n';
    }

    public Token nextToken() {
        for (; shouldSkip(peek) ; nextChar());
        if (peek == -1) {
            return lastToken = new Token("END", "");
        }

        StringBuilder b = new StringBuilder();
        while (peek != -1) {
            b.append((char) peek);

            String s = b.toString();

            if (s.length() > 1) {
                Token token = get(s);
                Token prevToken = get(s.substring(0, s.length() - 1));
//        System.out.println(s + " prev: " + prevWord + "; cur: " + word);

                if (prevToken != null && token == null) {
                    return lastToken = prevToken;
                }
            }

            if (peek == ' ') {
                throw new IllegalArgumentException("unknown token " + b.toString());
            }

            nextChar();
        }

        Token t = get(b.toString());
        if (t != null) {
            assert peek == -1;
            peek = ' ';
            return lastToken = t;
        }

        throw new IllegalArgumentException("unknown token " + b.toString());
    }

    private Token get(String key) {
        for (Pair pair : lexerRules) {
            Pattern r = Pattern.compile(pair.value);
            Matcher m = r.matcher(key + "\n");
            if (m.find()) {
                return new Token(pair.key, key);
            }
        }

        return null;
    }

    public Token curToken() {
        return lastToken;
    }

    private void nextChar() {
        curPos++;
        try {
            peek = is.read();
        } catch (IOException e) {
            assert false;
        }
    }

    public int getCurPos() {
        return curPos;
    }

    public class Token {
        public String name;
        public String text;

        public Token(String name, String text) {
            this.name = name;
            this.text = text;
        }
    }
}