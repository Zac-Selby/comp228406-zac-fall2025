package exercise1;

public abstract class Insurance{
    protected String insuranceType;
    protected double monthlyCost;

    //constructor
    public Insurance(String insuranceType){
        this.insuranceType = insuranceType;
    }

    //getters
    public String getInsuranceType() {
        return insuranceType;
    }
    public double getMonthlyCost() {
        return monthlyCost;
    }

    //abtract methods
    public abstract void setInsuranceCost(double monthlyCost);
    public abstract void displayInfo();
}