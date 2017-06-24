package ru.ifmo;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

public class Main {

    public static void main(String[] args) {
        String[] tests = {
                "if > 2 3 print 3 elif > 4 - 7 2 print + 3 4",
                "= a 42 if == a 42 print 42 = a -1.1 = b true if >= 1.0 a print != true b else print != true b"
        };

        for (String test: tests) {
            ANTLRInputStream in = new ANTLRInputStream(test);
            PrefixLexer lexer = new PrefixLexer(in);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            PrefixParser parser = new PrefixParser(tokens);
            System.out.println(parser.start().value);
        }
    }
}
