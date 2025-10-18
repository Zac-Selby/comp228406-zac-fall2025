package exercise3;
import java.util.Scanner;

public class ProcessMortgage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("CityToronto Mortgage Entry");
        double primeRate = readPrimeRate(sc); //decimal

        Mortgage[] mortgages = new Mortgage[3];

        for (int i = 0; i < mortgages.length; i++) {
            System.out.println("Enter Mortgage #" + (i+1) + ": ");

            String type = readType(sc); // B or P
            System.out.print("Enter mortgage number: ");
            String mNum = sc.nextLine().trim();

            System.out.print("Enter customer name: ");
            String cName = sc.nextLine().trim();

            double amount = readAmount(sc);
            int term = readTerm(sc); //1/3/5 or defaults to 1

            Mortgage m;
            if (type.equalsIgnoreCase("B")) {
                m = new BusinessMortgage(mNum, cName, amount, primeRate, term);
            } else {
                m = new PersonalMortgage(mNum, cName, amount, primeRate, term);
            }
            mortgages[i] = m;
        }

        System.out.println("All Mortgages:");
        for (Mortgage m : mortgages) {
            System.out.println(m.getMortgageInfo());
        }

        sc.close();
    }
    private static double readPrimeRate(Scanner sc) {
        while (true) {
            try {
                System.out.print("Enter current prime interest rate (as %, e.g., 6.5): ");
                String line = sc.nextLine().trim();
                double percent = Double.parseDouble(line);
                if (percent < 0) {
                    System.out.println("Prime rate cannot be negative.");
                    continue;
                }
                return percent / 100.0; // convert to decimal
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Try again.");
            }
        }
    }

    private static String readType(Scanner sc) {
        while (true) {
            System.out.print("Mortgage type (B = Business, P = Personal): ");
            String t = sc.nextLine().trim();
            if (t.equalsIgnoreCase("B") || t.equalsIgnoreCase("P")) return t;
            System.out.println("Invalid type. Please enter B or P.");
        }
    }

    private static double readAmount(Scanner sc) {
        while (true) {
            try {
                System.out.print("Enter mortgage amount (max $300000): ");
                String line = sc.nextLine().trim();
                double amt = Double.parseDouble(line);
                if (amt < 0) {
                    System.out.println("Amount cannot be negative.");
                    continue;
                }
                return amt; // capping is handled in Mortgage constructor
            } catch (NumberFormatException e) {
                System.out.println("Invalid amount. Try again.");
            }
        }
    }

    private static int readTerm(Scanner sc) {
        while (true) {
            try {
                System.out.print("Enter term in years (1, 3, or 5): ");
                String line = sc.nextLine().trim();
                int t = Integer.parseInt(line);
                // We accept any number; Mortgage will normalize to 1 if invalid.
                return t;
            } catch (NumberFormatException e) {
                System.out.println("Invalid term. Try again.");
            }
        }
    }
}