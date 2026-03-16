import java.util.*;

public class TokenBucket {

    int tokens;
    long lastRefill;

    TokenBucket(int tokens) {
        this.tokens = tokens;
        this.lastRefill = System.currentTimeMillis();
    }
}

class RateLimiter {

    HashMap<String, TokenBucket> clients = new HashMap<>();

    public boolean checkRateLimit(String clientId) {

        clients.putIfAbsent(clientId, new TokenBucket(1000));

        TokenBucket bucket = clients.get(clientId);

        if (bucket.tokens > 0) {
            bucket.tokens--;
            return true;
        }

        return false;
    }

    public static void main(String[] args) {

        RateLimiter obj = new RateLimiter();

        System.out.println(obj.checkRateLimit("abc"));
    }
}