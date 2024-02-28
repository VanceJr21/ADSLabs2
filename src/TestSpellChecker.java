public class TestSpellChecker {
    public static void main(String[] args) {
        SpellChecker sp = new SpellChecker("new_dictionary.txt");

        sp.readDictionary();
        sp.checkWord();
    }
}
