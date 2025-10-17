package exercise1;
import java.util.Scanner;

public class InsuranceApp{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Insurance[] policies = new Insurance[3];

        for(int i = 0; i < policies.length; i++){
            System.out.print("Enter insurance type (Life/Health): ");
            String type = sc.nextLine();

            Insurance policy;
            if (type.equalsIgnoreCase("Life")) {
                policy = new Life();
            } else if (type.equalsIgnoreCase("Health")) {
                policy = new Health();
            } else {
                System.out.println("Invalid type, defaulting to Health.");
                policy = new Health();
            }

            System.out.println("Enter monthly cost: ");
            double cost = sc.nextDouble();
            sc.nextLine();

            policy.setInsuranceCost(cost);
            policies[i] = policy;
        }

        System.out.println("\nInsurance Information");
        for (Insurance policy : policies) {
            policy.displayInfo();
            System.out.println();
        }

        sc.close();
    }
}