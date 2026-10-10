import java.util.Scanner;

abstract class Question {
    protected String correctAnswer;
    protected String studentAnswer;
    protected double points;

    public Question(
            String correctAnswer,
            String studentAnswer,
            double points) {
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    abstract double grade();

    abstract String getType();
}

class MCQ extends Question {
    public MCQ(String correct, String student, double points) {
        super(correct, student, points);
    }

    public double grade() {
        return correctAnswer.equalsIgnoreCase(studentAnswer)
                ? points : 0;
    }

    public String getType() {
        return "MCQ";
    }
}

class TrueFalse extends Question {
    public TrueFalse(String correct, String student, double points) {
        super(correct, student, points);
    }

    public double grade() {
        return correctAnswer.equalsIgnoreCase(studentAnswer)
                ? points : 0;
    }

    public String getType() {
        return "TF";
    }
}

class Essay extends Question {
    public Essay(String correct, String student, double points) {
        super(correct, student, points);
    }

    public double grade() {
        String[] keywords = correctAnswer.split(",");
        int matched = 0;

        for (String keyword : keywords) {
            if (studentAnswer.toLowerCase().contains(
                    keyword.trim().toLowerCase())) {
                matched++;
            }
        }

        if (matched >= 2) {
            return points * 0.75;
        } else if (matched == 1) {
            return points * 0.50;
        }

        return 0;
    }

    public String getType() {
        return "ESSAY";
    }
}

public class ExamGrader {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine().trim());
        Question[] questions = new Question[n];
        double total = 0;

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();

            String[] parts = line.split("\"");
            String type = parts[0].trim();

            String questionText = parts[1].trim();
            String correct = parts[3].trim();
            String student = parts[5].trim();

            double points = Double.parseDouble(parts[6].trim());

            switch (type) {
                case "MCQ":
                    questions[i] = new MCQ(
                            correct, student, points);
                    break;

                case "TF":
                    questions[i] = new TrueFalse(
                            correct, student, points);
                    break;

                case "ESSAY":
                    questions[i] = new Essay(
                            correct, student, points);
                    break;
            }
        }

        for (Question q : questions) {
            double score = q.grade();

            System.out.printf("%s: %.2f%n",
                    q.getType(), score);

            total += score;
        }

        System.out.printf("Total Score: %.2f%n", total);
        sc.close();
    }
}