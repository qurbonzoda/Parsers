package ru.ifmo;

import java.io.ByteArrayInputStream;
import java.text.ParseException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws ParseException {
        Parser parser = new Parser();
        String[] correctFunctionDeclarations =  {
                "function f(): void;",
                "procedure sadsad(var das: sads): sadjl;",
                "function   askadr (tyn: saj, var SAODKA   : saklj, var kjKJyty:    dfdfds) : ewewe;",
                "procedure   sadPooPsad \r  \t \n  ( \n sd \r : dstf \t , a:b):x\t;"
        };

        Arrays.stream(correctFunctionDeclarations).map(String::getBytes).map(ByteArrayInputStream::new)
                .forEach(x -> {
                    try {
                        parser.parse(x);
                        System.out.println("*** OK");
                    } catch (ParseException e) {
                        System.out.println(e);
                        e.printStackTrace();
                        throw new AssertionError();
                    }
                });
    }
}
