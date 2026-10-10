import java.util.Scanner;

abstract class Payment {
    protected double amount;

    public Payment(double amount) {
        this.amount = amount;
    }

    abstract double calculateAmount();

    abstract String getType();
}

class CardPayment extends Payment {
    public CardPayment(double amount) {
        super(amount);
    }

    public double calculateAmount() {
        return amount * 1.02;
    }

    public String getType() {
        return "CARD";
    }
}

class WalletPayment extends Payment {
    public WalletPayment(double amount) {
        super(amount);
    }

    public double calculateAmount() {
        return amount * 1.01;
    }

    public String getType() {
        return "WALLET";
    }
}

class BankTransfer extends Payment {
    public BankTransfer(double amount) {
        super(amount);
    }

    public double calculateAmount() {
        return amount;
    }

    public String getType() {
        return "BANKTRANSFER";
    }
}

public class PaymentSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Payment[] payments = new Payment[n];
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();

            switch (type) {
                case "CARD":
                    payments[i] = new CardPayment(amount);
                    break;
                case "WALLET":
                    payments[i] = new WalletPayment(amount);
                    break;
                case "BANKTRANSFER":
                    payments[i] = new BankTransfer(amount);
                    break;
            }
        }

        for (Payment p : payments) {
            double result = p.calculateAmount();

            System.out.printf("%s: %.2f%n",
                    p.getType(), result);

            total += result;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}