import java.util.Scanner;
import java.time.LocalDate;

abstract class LibraryItem {
    protected String title;

    public LibraryItem(String title) {
        this.title = title;
    }

    abstract int getLoanPeriod();

    public LocalDate getDueDate() {
        return LocalDate.of(2023, 10, 26)
                .plusDays(getLoanPeriod());
    }
}

class Book extends LibraryItem {
    public Book(String title) {
        super(title);
    }

    public int getLoanPeriod() {
        return 14;
    }
}

class DVD extends LibraryItem {
    public DVD(String title) {
        super(title);
    }

    public int getLoanPeriod() {
        return 7;
    }
}

class Magazine extends LibraryItem {
    public Magazine(String title) {
        super(title);
    }

    public int getLoanPeriod() {
        return 3;
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        LibraryItem[] items = new LibraryItem[n];

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();

            int space = line.indexOf(' ');
            String type = line.substring(0, space);
            String title = line.substring(space + 1).trim();

            if (title.startsWith("\"") && title.endsWith("\"")) {
                title = title.substring(1, title.length() - 1);
            }

            switch (type) {
                case "BOOK":
                    items[i] = new Book(title);
                    break;
                case "DVD":
                    items[i] = new DVD(title);
                    break;
                case "MAGAZINE":
                    items[i] = new Magazine(title);
                    break;
            }
        }

        for (LibraryItem item : items) {
            System.out.println(
                    item.title + ": " + item.getDueDate());
        }

        sc.close();
    }
}