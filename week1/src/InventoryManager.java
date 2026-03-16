import java.util.*;

public class InventoryManager {

    HashMap<String, Integer> stock = new HashMap<>();
    LinkedHashMap<Integer, Integer> waitingList = new LinkedHashMap<>();

    public void checkStock(String product) {

        System.out.println(stock.get(product) + " units available");
    }

    public void purchaseItem(String product, int userId) {

        int currentStock = stock.get(product);

        if (currentStock > 0) {
            stock.put(product, currentStock - 1);
            System.out.println("Purchase successful. Remaining: " + (currentStock - 1));
        } else {

            waitingList.put(userId, waitingList.size() + 1);
            System.out.println("Added to waiting list. Position: " + waitingList.size());
        }
    }

    public static void main(String[] args) {

        InventoryManager obj = new InventoryManager();

        obj.stock.put("IPHONE15", 2);

        obj.purchaseItem("IPHONE15", 1);
        obj.purchaseItem("IPHONE15", 2);
        obj.purchaseItem("IPHONE15", 3);
    }
}
