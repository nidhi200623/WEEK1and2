
    import java.util.*;

    public class Analytics {

        HashMap<String, Integer> pageViews = new HashMap<>();
        HashMap<String, Set<String>> uniqueVisitors = new HashMap<>();
        HashMap<String, Integer> sources = new HashMap<>();

        public void processEvent(String url, String userId, String source) {

            pageViews.put(url, pageViews.getOrDefault(url, 0) + 1);

            uniqueVisitors.putIfAbsent(url, new HashSet<>());
            uniqueVisitors.get(url).add(userId);

            sources.put(source, sources.getOrDefault(source, 0) + 1);
        }

        public void dashboard() {

            System.out.println("Page Views: " + pageViews);
            System.out.println("Traffic Sources: " + sources);
        }

        public static void main(String[] args) {

            Analytics obj = new Analytics();

            obj.processEvent("/news", "u1", "google");
            obj.processEvent("/news", "u2", "facebook");

            obj.dashboard();
        }
    }

