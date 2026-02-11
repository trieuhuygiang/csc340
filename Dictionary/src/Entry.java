public class Entry {

    private String keyword;
    private String partOfSpeech;
    private String definition;

    public Entry(String keyword, String partOfSpeech, String definition) {
        this.keyword = keyword;
        this.partOfSpeech = partOfSpeech;
        this.definition = definition;
    }

    public String getKeyword() {
        return keyword;
    }

    public String getPartOfSpeech() {
        return partOfSpeech;
    }

    public String getDefinition() {
        return definition;
    }
}

enum DataSource { // This is created by AI
    // keyword, partOfSpeech, definition

    // --- Arrow (1) ---
    ARROW_1("Arrow", "noun", "Here is one arrow: <IMG> -=>> </IMG>"),

    // --- Book (4) ---
    BOOK_1("Book", "noun", "A set of pages."),
    BOOK_2("Book", "noun", "A written work published in printed or electronic form."),
    BOOK_3("Book", "verb", "To arrange for someone to have a seat on a plane."),
    BOOK_4("Book", "verb", "To arrange something on a particular date."),

    // --- Distinct (8, includes duplicates) ---
    DISTINCT_1("Distinct", "adjective", "Familiar. Worked in Java."),
    DISTINCT_2("Distinct", "adjective", "Unique. No duplicates. Clearly different or of a different kind."),
    DISTINCT_3("Distinct", "adverb", "Uniquely. Written \"distinctly\"."),
    DISTINCT_4("Distinct", "noun", "A keyword in this assignment."),
    DISTINCT_5("Distinct", "noun", "A keyword in this assignment."),
    DISTINCT_6("Distinct", "noun", "A keyword in this assignment."),
    DISTINCT_7("Distinct", "noun", "An advanced search option."),
    DISTINCT_8("Distinct", "noun", "Distinct is a parameter in this assignment."),

    // --- Placeholder (11) ---
    PLACEHOLDER_1("Placeholder", "adjective", "To be updated..."),
    PLACEHOLDER_2("Placeholder", "adjective", "To be updated..."),
    PLACEHOLDER_3("Placeholder", "adverb", "To be updated..."),
    PLACEHOLDER_4("Placeholder", "conjunction", "To be updated..."),
    PLACEHOLDER_5("Placeholder", "interjection", "To be updated..."),
    PLACEHOLDER_6("Placeholder", "noun", "To be updated..."),
    PLACEHOLDER_7("Placeholder", "noun", "To be updated..."),
    PLACEHOLDER_8("Placeholder", "noun", "To be updated..."),
    PLACEHOLDER_9("Placeholder", "preposition", "To be updated..."),
    PLACEHOLDER_10("Placeholder", "pronoun", "To be updated..."),
    PLACEHOLDER_11("Placeholder", "verb", "To be updated..."),

    // --- Reverse (15) ---
    REVERSE_1("Reverse", "adjective", "On back side."),
    REVERSE_2("Reverse", "adjective", "Opposite to usual or previous arrangement."),
    REVERSE_3("Reverse", "noun", "A dictionary program's parameter."),
    REVERSE_4("Reverse", "noun", "Change to opposite direction."),
    REVERSE_5("Reverse", "noun", "The opposite."),
    REVERSE_6("Reverse", "noun", "To be updated..."),
    REVERSE_7("Reverse", "noun", "To be updated..."),
    REVERSE_8("Reverse", "noun", "To be updated..."),
    REVERSE_9("Reverse", "noun", "To be updated..."),
    REVERSE_10("Reverse", "verb", "Change something to opposite."),
    REVERSE_11("Reverse", "verb", "Go back"),
    REVERSE_12("Reverse", "verb", "Revoke ruling."),
    REVERSE_13("Reverse", "verb", "To be updated..."),
    REVERSE_14("Reverse", "verb", "To be updated..."),
    REVERSE_15("Reverse", "verb", "Turn something inside out."),
    // Additional keywords (14 more needed to reach 19 total)
    HELP_NOUN_1("Help", "noun", "Assistance or support."),
    HELP_VERB_1("Help", "verb", "To provide assistance."),

    SEARCH_NOUN_1("Search", "noun", "An attempt to find something."),
    SEARCH_VERB_1("Search", "verb", "To look for something."),

    PARAMETER_NOUN_1("Parameter", "noun", "A value used in a function or operation."),
    PARAMETER_NOUN_2("Parameter", "noun", "A setting or configuration option."),

    OPTIONAL_ADJECTIVE_1("Optional", "adjective", "Not required; able to be left out."),
    OPTIONAL_ADJECTIVE_2("Optional", "adjective", "Available to be chosen but not necessary."),

    PROGRAM_NOUN_1("Program", "noun", "A set of instructions for a computer."),
    PROGRAM_NOUN_2("Program", "noun", "A series of activities or presentations."),

    KEYWORD_NOUN_1("Keyword", "noun", "A word used as a search term."),
    KEYWORD_NOUN_2("Keyword", "noun", "A significant or important word."),

    DEFINITION_NOUN_1("Definition", "noun", "A statement of the meaning of a word or term."),
    DEFINITION_NOUN_2("Definition", "noun", "The act of defining or making clear."),

    INTERFACE_NOUN_1("Interface", "noun", "A point where two systems meet and interact."),
    INTERFACE_NOUN_2("Interface", "noun", "A device for connecting components."),

    INPUT_NOUN_1("Input", "noun", "Data or information provided to a system."),

    OUTPUT_NOUN_1("Output", "noun", "Result or information produced by a system."),

    DATA_NOUN_1("Data", "noun", "Information in the form of facts or statistics."),

    STRUCTURE_NOUN_1("Structure", "noun", "The way something is organized or constructed."),

    EFFICIENT_ADJECTIVE_1("Efficient", "adjective", "Working well and using minimal resources."),

    DYNAMIC_ADJECTIVE_1("Dynamic", "adjective", "Characterized by energy or effective action.");

    public final String keyword;
    public final String partOfSpeech;
    public final String definition;

    DataSource(String keyword, String partOfSpeech, String definition) {
        this.keyword = keyword;
        this.partOfSpeech = partOfSpeech;
        this.definition = definition;
    }
}