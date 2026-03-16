public class ParkingLot {
    String[] spots = new String[500];

    int hash(String plate) {
        return Math.abs(plate.hashCode()) % 500;
    }

    public void park(String plate) {

        int index = hash(plate);

        while (spots[index] != null) {
            index = (index + 1) % 500;
        }

        spots[index] = plate;

        System.out.println("Parked at spot " + index);
    }

    public static void main(String[] args) {

        ParkingLot obj = new ParkingLot();

        obj.park("ABC123");
        obj.park("ABC124");
    }
}
