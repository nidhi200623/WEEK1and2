import java.util.*;

class DNSEntry {

    String ip;
    long expiry;

    DNSEntry(String ip, long ttl) {
        this.ip = ip;
        this.expiry = System.currentTimeMillis() + ttl;
    }
}

public class DNSCache {

    HashMap<String, DNSEntry> cache = new HashMap<>();

    public String resolve(String domain) {

        if (cache.containsKey(domain)) {

            DNSEntry entry = cache.get(domain);

            if (System.currentTimeMillis() < entry.expiry) {
                return "Cache HIT: " + entry.ip;
            } else {
                cache.remove(domain);
            }
        }

        String ip = "172.217.14." + new Random().nextInt(255);

        cache.put(domain, new DNSEntry(ip, 5000));

        return "Cache MISS: " + ip;
    }

    public static void main(String[] args) {

        DNSCache obj = new DNSCache();

        System.out.println(obj.resolve("google.com"));
        System.out.println(obj.resolve("google.com"));
    }
}
