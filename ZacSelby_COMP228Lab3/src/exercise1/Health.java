package exercise1;

public class Health extends Insurance{
    public Health() {
        super("Health");
    }

    public void setInsuranceCost(double monthlyCost){
        this.monthlyCost = monthlyCost;
    }

    public void displayInfo() {
        System.out.println("Insurance Type: " + insuranceType);
        System.out.println("Monthly Cost: $" + String.format("%.2f", monthlyCost));
    }
}