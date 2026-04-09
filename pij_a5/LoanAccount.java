public class LoanAccount extends Account {
    private double interestRate;
    private int tenureMonths;
    private String loanType;

    public LoanAccount(Customer customer, String accNo, double loanAmount,
                       double interestRate, int tenureMonths, String loanType) {
        super(customer, accNo, loanAmount, "Loan");
        this.interestRate = interestRate;
        this.tenureMonths = tenureMonths;
        this.loanType = loanType;
    }

    @Override
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid repayment amount.");
            return;
        }
        if (amount > balance) {
            System.out.println("Repayment exceeds loan balance.");
        } else {
            balance -= amount;
            System.out.println("Loan repaid: " + amount);
        }
    }

    @Override
    public void withdraw(double amount) {
        System.out.println("Withdrawal not allowed in Loan Account.");
    }

    public double calculateEMI() {
        double r = interestRate / 100 / 12;
        return (balance * r * Math.pow(1 + r, tenureMonths)) /
               (Math.pow(1 + r, tenureMonths) - 1);
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Loan Type: " + loanType);
        System.out.println("EMI: " + Math.round(calculateEMI()));
    }
}