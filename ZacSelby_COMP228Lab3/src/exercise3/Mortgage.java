package exercise3;

public abstract class Mortgage implements MortgageConstants {
    protected String mortgageNumber;
    protected String customerName;
    protected double amount;
    protected double interestRate;
    protected int term;

    public Mortgage(String mortgageNumber, String customerName, double amount, double interestRate, int term) {
        this.mortgageNumber = mortgageNumber;
        this.customerName = customerName;

        if (amount > MAX_MORTGAGE_AMOUNT) {
            this.amount = MAX_MORTGAGE_AMOUNT;
        } else if (amount < 0) {
            this.amount = 0;
        } else {
            this.amount = amount;
        }

        //if term not allowed constant, force to short term
        if (term == SHORT_TERM || term == MEDIUM_TERM || term == LONG_TERM) {
            this.term = term;
        } else {
            this.term = SHORT_TERM;
        }

        this.interestRate = interestRate;
    }

    public String getMortgageInfo() {
        // Simple interest over the term
        double totalOwed = amount + (amount * interestRate * term);

        StringBuilder sb = new StringBuilder();
        sb.append("Bank: ").append(BANK_NAME).append('\n');
        sb.append("Mortgage #: ").append(mortgageNumber).append('\n');
        sb.append("Customer: ").append(customerName).append('\n');
        sb.append("Principal: $").append(String.format("%.2f", amount)).append('\n');
        sb.append("Annual Rate: ").append(String.format("%.2f", interestRate * 100)).append("%\n");
        sb.append("Term (years): ").append(term).append('\n');
        sb.append("Total Owed (simple interest): $")
                .append(String.format("%.2f", totalOwed)).append('\n');
        return sb.toString();
    }

    public String getMortgageNumber() { return mortgageNumber; }
    public String getCustomerName() { return customerName; }
    public double getAmount() { return amount; }
    public double getInterestRate() { return interestRate; }
    public int getTerm() { return term; }
}