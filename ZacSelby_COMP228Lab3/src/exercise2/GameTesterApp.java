package exercise2;
import java.util.Scanner;

public class GameTesterApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter tester name:");
        String name = sc.nextLine();

        System.out.println("Is the tester full-time or part-time (F/P): ");
        String type = sc.nextLine();

        GameTester tester;

        if (type.equalsIgnoreCase("F")) {
            tester = new FullTimeGameTester(name);
        } else if (type.equalsIgnoreCase("P")) {
            System.out.println("Enter number of hours worked:");
            int hours = sc.nextInt();
            tester = new PartTimeGameTester(name, hours);
        } else {
            System.out.println("Invalid type. Defaulting to full-time.");
            tester = new FullTimeGameTester(name);
        }

        System.out.println("Tester Information");
        System.out.println(tester.toString());
        System.out.println("Salary: $" + String.format("%.2f", tester.determineSalary()));

        sc.close();
    }
}