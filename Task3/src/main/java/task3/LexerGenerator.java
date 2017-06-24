package task3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by bigdreamer on 14.06.17.
 */
public class LexerGenerator {
    private HashMap<String, ArrayList<String>> lexerRules;

    public LexerGenerator(HashMap<String, ArrayList<String>> lexerRules) {
        super();
        this.lexerRules = new HashMap<>(lexerRules);

        for (Map.Entry<String, ArrayList<String>> entry: this.lexerRules.entrySet()) {
            for (String value: entry.getValue()) {
                assert value.startsWith("'") && value.endsWith("'");
            }
        }
    }

    public void generateLexer() {
        String prototypePath = "/Users/bigdreamer/Programming/Parsers/Task3/src/main/java/" +
                "prototypes/GeneratedLexerPrototype.txt";
        try (Scanner lexer = new Scanner(new File(prototypePath))) {

            String newLexer = lexer.useDelimiter("\\Z").next().replace("%%INSERT_RULES%%", getRules());

            String path = "/Users/bigdreamer/Programming/Parsers/Task3/src/main/java/generated/GeneratedLexer.java";
            try (PrintWriter lexerOut = new PrintWriter(new FileOutputStream(path))) {
                lexerOut.print(newLexer);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private String getRules() {
        String rules = "";

        for (Map.Entry<String, ArrayList<String>> entry : lexerRules.entrySet()) {
            for (String v: entry.getValue()) {
                String u = v.substring(1, v.length() - 1);
                String charsToEscape = "\\.[]{}()*+-?^$|";
                for (int i = 0; i < charsToEscape.length(); i++) {
                    String ch = charsToEscape.substring(i, i + 1);
                    u = u.replace(ch, "\\\\" + ch);
                }

                rules += "        put(\"" + entry.getKey() + "\", \"^" + u + "$\");\n";
            }
        }
        return rules;
    }
}
