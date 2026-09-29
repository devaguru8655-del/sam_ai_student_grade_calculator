import java.util.ArrayList;
import java.util.Scanner;

// Task 2 - Student Grade Calculator
// Takes marks for a number of subjects, then shows total, average and grade.
public class StudentGradeCalculator {

    // Grade rules: A >= 80, B >= 60, C >= 40, otherwise Fail
    static String getGrade(double average) {
        if (average >= 80) {
            return "A";
        } else if (average >= 60) {
            return "B";
        } else if (average >= 40) {
            return "C";
        } else {
            return "Fail";
        }
    }

    // keeps asking until the user types a valid whole number in the given range
    static int readInt(Scanner sc, String message, int min, int max) {
        while (true) {
            System.out.print(message);
            if (!sc.hasNext()) {
                throw new IllegalStateException("Input ended unexpectedly");
            }
            String text = sc.next();
            try {
                int value = Integer.parseInt(text);
                if (value >= min && value <= max) {
                    return value;
                }
                System.out.println("Enter a value between " + min + " and " + max + ".");
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> marks = new ArrayList<>();

        System.out.println("=== Student Grade Calculator ===");
        int subjects = readInt(sc, "How many subjects? ", 1, 20);

        for (int i = 1; i <= subjects; i++) {
            marks.add(readInt(sc, "Marks for subject " + i + " (0-100): ", 0, 100));
        }

        int total = 0;
        for (int m : marks) {
            total += m;
        }
        double average = (double) total / subjects;   // out of 100, so this is also the percentage

        System.out.println("\n----- Result -----");
        System.out.println("Marks     : " + marks);
        System.out.println("Total     : " + total + " / " + (subjects * 100));
        System.out.printf("Average   : %.2f%%%n", average);
        System.out.println("Grade     : " + getGrade(average));
        sc.close();
    }
}
