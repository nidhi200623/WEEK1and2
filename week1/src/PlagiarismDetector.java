import java.util.*;

public class PlagiarismDetector {

    HashMap<String, Set<String>> index = new HashMap<>();

    public void addDocument(String docId, String text) {

        String[] words = text.split(" ");

        for (int i = 0; i < words.length - 2; i++) {

            String ngram = words[i] + " " + words[i + 1] + " " + words[i + 2];

            index.putIfAbsent(ngram, new HashSet<>());

            index.get(ngram).add(docId);
        }
    }

    public void analyze(String docId, String text) {

        int matches = 0;

        String[] words = text.split(" ");

        for (int i = 0; i < words.length - 2; i++) {

            String ngram = words[i] + " " + words[i + 1] + " " + words[i + 2];

            if (index.containsKey(ngram))
                matches++;
        }

        System.out.println("Matching ngrams: " + matches);
    }

    public static void main(String[] args) {

        PlagiarismDetector obj = new PlagiarismDetector();

        obj.addDocument("doc1", "this is an example document for testing");

        obj.analyze("doc2", "this is an example test");
    }
}