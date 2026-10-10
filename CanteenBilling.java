import java.util.Scanner;

public class CanteenBilling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();
            double bill = 0;

            switch (type) {
                case "STUDENT":
                    bill = amount * 0.90;
                    break;

                case "STAFF":
                    bill = amount * 0.95;
                    break;

                case "GUEST":
                    bill = amount + 10;
                    break;
            }

            System.out.printf("%s: %.2f%n", type, bill);
            total += bill;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}