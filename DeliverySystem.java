import java.util.Scanner;

abstract class Delivery {
    protected double weight;
    protected double distance;

    public Delivery(double weight, double distance) {
        this.weight = weight;
        this.distance = distance;
    }

    abstract double calculateFee();

    abstract String getType();
}

class StandardDelivery extends Delivery {
    public StandardDelivery(double weight, double distance) {
        super(weight, distance);
    }

    public double calculateFee() {
        return 5 + weight * 0.50 + distance * 0.10;
    }

    public String getType() {
        return "STANDARD";
    }
}

class ExpressDelivery extends Delivery {
    public ExpressDelivery(double weight, double distance) {
        super(weight, distance);
    }

    public double calculateFee() {
        return 15 + weight + distance * 0.20;
    }

    public String getType() {
        return "EXPRESS";
    }
}

class InternationalDelivery extends Delivery {
    private double customsFee;

    public InternationalDelivery(
            double weight, double distance, double customsFee) {
        super(weight, distance);
        this.customsFee = customsFee;
    }

    public double calculateFee() {
        return 25 + weight * 2 + distance * 0.50 + customsFee;
    }

    public String getType() {
        return "INTERNATIONAL";
    }
}

public class DeliverySystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Delivery[] deliveries = new Delivery[n];
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double weight = sc.nextDouble();
            double distance = sc.nextDouble();

            switch (type) {
                case "STANDARD":
                    deliveries[i] =
                            new StandardDelivery(weight, distance);
                    break;

                case "EXPRESS":
                    deliveries[i] =
                            new ExpressDelivery(weight, distance);
                    break;

                case "INTERNATIONAL":
                    double customs = sc.nextDouble();
                    deliveries[i] =
                            new InternationalDelivery(
                                    weight, distance, customs);
                    break;

                default:
                    throw new IllegalArgumentException(
                            "Invalid delivery type");
            }
        }

        for (Delivery d : deliveries) {
            double fee = d.calculateFee();

            System.out.printf("%s: %.2f%n",
                    d.getType(), fee);

            total += fee;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}