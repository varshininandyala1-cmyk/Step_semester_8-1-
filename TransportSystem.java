import java.util.Scanner;

abstract class Transport {
    protected double distance;

    public Transport(double distance) {
        this.distance = distance;
    }

    abstract double calculateFare();

    abstract String getType();
}

class Bus extends Transport {
    public Bus(double distance) {
        super(distance);
    }

    public double calculateFare() {
        return Math.min(2 + distance * 0.10, 10);
    }

    public String getType() {
        return "BUS";
    }
}

class Train extends Transport {
    public Train(double distance) {
        super(distance);
    }

    public double calculateFare() {
        return 3 + distance * 0.15;
    }

    public String getType() {
        return "TRAIN";
    }
}

class Metro extends Transport {
    private double peakHourFactor;

    public Metro(double distance, double peakHourFactor) {
        super(distance);
        this.peakHourFactor = peakHourFactor;
    }

    public double calculateFare() {
        return (1.50 + distance * 0.20) * peakHourFactor;
    }

    public String getType() {
        return "METRO";
    }
}

public class TransportSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Transport[] journeys = new Transport[n];
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double distance = sc.nextDouble();

            switch (type) {
                case "BUS":
                    journeys[i] = new Bus(distance);
                    break;

                case "TRAIN":
                    journeys[i] = new Train(distance);
                    break;

                case "METRO":
                    double factor = sc.nextDouble();
                    journeys[i] = new Metro(distance, factor);
                    break;
            }
        }

        for (Transport t : journeys) {
            double fare = t.calculateFare();

            System.out.printf("%s: %.2f%n",
                    t.getType(), fare);

            total += fare;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}