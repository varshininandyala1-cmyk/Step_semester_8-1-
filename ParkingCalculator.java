import java.util.Scanner;

public class ParkingCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int hours = sc.nextInt();
            double charge = 0;

            switch (type) {
                case "BIKE":
                    charge = hours * 10;
                    break;

                case "CAR":
                    charge = 30 + (hours - 1) * 20;
                    break;

                case "TRUCK":
                    charge = Math.max(hours * 50, 100);
                    break;
            }

            System.out.printf("%s: %.2f%n", type, charge);
            total += charge;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}