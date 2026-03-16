import java.util.*;

public class Autocomplete {

    HashMap<String, Integer> queries = new HashMap<>();

    public void addQuery(String q) {
        queries.put(q, queries.getOrDefault(q, 0) + 1);
    }

    public void search(String prefix) {

        for (String q : queries.keySet()) {

            if (q.startsWith(prefix))
                System.out.println(q + " : " + queries.get(q));
        }
    }

    public static void main(String[] args) {

        Autocomplete obj = new Autocomplete();

        obj.addQuery("java tutorial");
        obj.addQuery("javascript course");

        obj.search("jav");
    }
}