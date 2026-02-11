import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Dictionary {

    private ArrayList<Entry> entries;

    public Dictionary() {
        entries = new ArrayList<>();
    }

    // Load from enum (this is NOT "hard coding" in Main; it's a Data Source)
    public void load() {
        for (DataSource d : DataSource.values()) {
            entries.add(new Entry(d.keyword, d.partOfSpeech, d.definition));
        }
    }

    public int getDefinitionCount() {
        return entries.size();
    }

    public int getKeywordCount() {
        Set<String> words = new HashSet<>();
        for (Entry e : entries) {
            words.add(e.getKeyword().toLowerCase());
        }
        return words.size();
    }

    // Search by keyword + optional partOfSpeech
    // If partOfSpeech == null => accept any part of speech
    public ArrayList<Entry> search(String keyword, String partOfSpeech) {
        ArrayList<Entry> results = new ArrayList<>();

        for (Entry e : entries) {
            boolean keywordMatch = e.getKeyword().equalsIgnoreCase(keyword);
            boolean posMatch = (partOfSpeech == null) || e.getPartOfSpeech().equalsIgnoreCase(partOfSpeech);

            if (keywordMatch && posMatch) {
                results.add(e);
            }
        }
        return results;
    }

    // Remove duplicates by (keyword + POS + definition)
    public ArrayList<Entry> distinct(ArrayList<Entry> list) {
        ArrayList<Entry> results = new ArrayList<>();
        Set<String> seen = new HashSet<>();

        for (Entry e : list) {
            // '|' is only a separator for building a "unique key" string.
            // It will NOT print to the user.
            String key = e.getKeyword().toLowerCase()
                    + "|" + e.getPartOfSpeech().toLowerCase()
                    + "|" + e.getDefinition().toLowerCase();

            if (!seen.contains(key)) {
                seen.add(key);
                results.add(e);
            }
        }
        return results;
    }

    // Reverse ordering
    public ArrayList<Entry> reverse(ArrayList<Entry> list) {
        ArrayList<Entry> results = new ArrayList<>();

        for (int i = list.size() - 1; i >= 0; i--) {
            results.add(list.get(i));
        }
        return results;
    }
}