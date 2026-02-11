import java.util.ArrayList;
import java.util.Scanner;

/**
 * UI class handles user interface for the Dictionary application.
 * Manages user input, parameter parsing, and result display.
 */
public class UI {

    private Dictionary dict;
    private Scanner scanner;

    public UI() {
        this.dict = new Dictionary();
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        initializeDisplay();
        searchLoop();
        scanner.close();
    }

    // Display Methods
    private void initializeDisplay() {
        System.out.println("! Loading data...");
        dict.load();
        System.out.println("! Loading completed...\n");

        System.out.println("===== DICTIONARY 340 JAVA =====");
        System.out.println("----- Keywords: " + dict.getKeywordCount());
        System.out.println("----- Definitions: " + dict.getDefinitionCount());
        System.out.println();
    }

    private void printBar() {
        System.out.println("|");
    }

    private void printHelpBlock() {
        printBar();
        System.out.println("PARAMETER HOW-TO, please enter:");
        System.out.println("1. A search key -then 2. An optional part of speech -then");
        System.out.println("3. An optional 'distinct' -then 4. An optional 'reverse'");
        printBar();
    }

    private void displayResults(ArrayList<Entry> results, boolean hadWarning) {
        printBar();

        if (results.isEmpty()) {
            System.out.println("<NOT FOUND> To be considered for the next release. Thank you.");
            printBar();

            if (!hadWarning) {
                printHelpBlock();
            }
        } else {
            for (Entry e : results) {
                System.out.println(
                        titleCase(e.getKeyword()) +
                                " [" + e.getPartOfSpeech().toLowerCase() + "] : " +
                                e.getDefinition());
            }
            printBar();
        }
    }

    // Search Loop
    private void searchLoop() {
        int searchCount = 1;

        while (true) {
            System.out.print("Search [" + searchCount + "]: ");
            String input = scanner.nextLine().trim();

            // Handle quit command
            if (input.equalsIgnoreCase("!q")) {
                System.out.println("-----THANK YOU-----");
                break;
            }

            // Handle empty input or help command
            if (input.isEmpty() || input.equalsIgnoreCase("!help")) {
                printHelpBlock();
                searchCount++;
                continue;
            }

            // Parse input
            String[] parts = input.split("\\s+");

            if (parts.length > 4) {
                printHelpBlock();
                searchCount++;
                continue;
            }

            // Process search
            SearchParams params = parseParameters(parts);

            if (params.hadWarning) {
                searchCount++;
                continue;
            }

            ArrayList<Entry> results = dict.search(params.keyword, params.pos);

            if (params.wantDistinct)
                results = dict.distinct(results);
            if (params.wantReverse)
                results = dict.reverse(results);

            displayResults(results, params.hadWarning);
            searchCount++;
        }
    }

    // Parameter Parsing
    private SearchParams parseParameters(String[] parts) {
        SearchParams params = new SearchParams();
        params.keyword = parts[0];
        boolean hadWarning = false;

        // Parse 2nd parameter
        if (parts.length >= 2) {
            hadWarning = processSecondParameter(parts[1], params) || hadWarning;
        }

        // Parse 3rd parameter
        if (parts.length >= 3) {
            hadWarning = processThirdParameter(parts[2], params) || hadWarning;
        }

        // Parse 4th parameter
        if (parts.length >= 4) {
            hadWarning = processFourthParameter(parts[3], params) || hadWarning;
        }

        params.hadWarning = hadWarning;
        return params;
    }

    private boolean processSecondParameter(String p2, SearchParams params) {
        if (isPartOfSpeech(p2)) {
            params.pos = p2;
            return false;
        } else if (p2.equalsIgnoreCase("distinct")) {
            params.wantDistinct = true;
            return false;
        } else if (p2.equalsIgnoreCase("reverse")) {
            params.wantReverse = true;
            return false;
        } else {
            printBar();
            System.out.println("<The entered 2nd parameter '" + p2 + "' is NOT a part of speech.>");
            System.out.println("<The entered 2nd parameter '" + p2 + "' is NOT 'distinct'.>");
            System.out.println("<The entered 2nd parameter '" + p2 + "' is NOT 'reverse'.>");
            System.out.println("<The entered 2nd parameter '" + p2 + "' was disregarded.>");
            System.out.println("<The 2nd parameter should be a part of speech or 'distinct' or 'reverse'.>");
            printBar();
            printBar();
            return true;
        }
    }

    private boolean processThirdParameter(String p3, SearchParams params) {
        if (p3.equalsIgnoreCase("distinct")) {
            params.wantDistinct = true;
            return false;
        } else if (p3.equalsIgnoreCase("reverse")) {
            params.wantReverse = true;
            return false;
        } else {
            printBar();
            System.out.println("<The entered 3rd parameter '" + p3 + "' is NOT 'distinct'.>");
            System.out.println("<The entered 3rd parameter '" + p3 + "' is NOT 'reverse'.>");
            System.out.println("<The entered 3rd parameter '" + p3 + "' was disregarded.>");
            System.out.println("<The 3rd parameter should be 'distinct' or 'reverse'.>");
            printBar();
            printBar();
            return true;
        }
    }

    private boolean processFourthParameter(String p4, SearchParams params) {
        if (p4.equalsIgnoreCase("reverse")) {
            params.wantReverse = true;
            return false;
        } else {
            printBar();
            System.out.println("<The entered 4th parameter '" + p4 + "' is NOT 'reverse'.>");
            System.out.println("<The entered 4th parameter '" + p4 + "' was disregarded.>");
            System.out.println("<The 4th parameter should be 'reverse'.>");
            printBar();
            printBar();
            return true;
        }
    }

    // Utility Methods
    private boolean isPartOfSpeech(String token) {
        if (token == null)
            return false;
        String t = token.toLowerCase();

        return t.equals("noun")
                || t.equals("verb")
                || t.equals("adjective")
                || t.equals("adverb")
                || t.equals("conjunction")
                || t.equals("interjection")
                || t.equals("preposition")
                || t.equals("pronoun");
    }

    private String titleCase(String s) {
        if (s == null || s.isEmpty())
            return s;
        String lower = s.toLowerCase();
        return Character.toUpperCase(lower.charAt(0)) + lower.substring(1);
    }

    // Helper Class
    private static class SearchParams {
        String keyword;
        String pos = null;
        boolean wantDistinct = false;
        boolean wantReverse = false;
        boolean hadWarning = false;
    }
}
