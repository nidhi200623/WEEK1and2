import java.util.*;

public class MultiCache {

    HashMap<String, String> L1 = new HashMap<>();
    HashMap<String, String> L2 = new HashMap<>();

    public String getVideo(String id) {

        if (L1.containsKey(id)) {
            return "L1 HIT";
        }

        if (L2.containsKey(id)) {

            L1.put(id, L2.get(id));
            return "L2 HIT → promoted to L1";
        }

        L2.put(id, "videoData");

        return "Database HIT";
    }

    public static void main(String[] args) {

        MultiCache obj = new MultiCache();

        System.out.println(obj.getVideo("v1"));
        System.out.println(obj.getVideo("v1"));
    }
}
