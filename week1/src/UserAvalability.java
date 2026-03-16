import java.util.*;
public class UserAvalability {
    HashMap<String, Integer> users = new HashMap<>();
    HashMap<String, Integer> attempts = new HashMap<>();

    public boolean checkAvailability(String username) {

        attempts.put(username, attempts.getOrDefault(username, 0) + 1);

        return !users.containsKey(username);
    }

    public List<String> suggestAlternatives(String username) {

        List<String> suggestions = new ArrayList<>();

        suggestions.add(username + "1");
        suggestions.add(username + "2");
        suggestions.add(username.replace("_", "."));

        return suggestions;
    }

    public String getMostAttempted() {

        String maxUser = "";
        int max = 0;

        for (String u : attempts.keySet()) {
            if (attempts.get(u) > max) {
                max = attempts.get(u);
                maxUser = u;
            }
        }

        return maxUser;
    }

    public static void main(String[] args) {

        UserAvalability obj = new UserAvalability();

        obj.users.put("john_doe", 1);

        System.out.println(obj.checkAvailability("john_doe"));
        System.out.println(obj.checkAvailability("jane_smith"));
        System.out.println(obj.suggestAlternatives("john_doe"));
    }
}
