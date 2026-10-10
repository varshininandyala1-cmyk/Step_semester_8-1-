import java.util.Scanner;

public class ElectricityBill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int units = sc.nextInt();
            double bill = 0;

            switch (type) {
                case "SINGLE":
                    bill = units * 8;
                    break;

                case "SHARED":
                    int occupants = sc.nextInt();
                    bill = (units * 6.0) / occupants;
                    break;

                case "AC":
                    bill = units * 10 + 200;
                    break;
            }

            System.out.printf("%s: %.2f%n", type, bill);
            total += bill;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}