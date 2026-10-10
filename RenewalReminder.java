import java.util.Scanner;
import java.time.LocalDate;

public class RenewalReminder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            String date = sc.next();

            int days = 0;

            switch (type) {
                case "BASIC":
                    days = 30;
                    break;

                case "STANDARD":
                    days = 90;
                    break;

                case "PREMIUM":
                    days = 365;
                    break;
            }

            LocalDate startDate = LocalDate.parse(date);
            LocalDate renewalDate = startDate.plusDays(days);

            System.out.println(name + ": " + renewalDate);
        }

        sc.close();
    }
}