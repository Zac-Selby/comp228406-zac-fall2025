package exercise3;

public class BusinessMortgage extends Mortgage {
    public BusinessMortgage(String mortgageNumber, String customerName, double amount, double primeRate, int term) {
        super(mortgageNumber, customerName, amount, primeRate + 0.01, term);
    }
}