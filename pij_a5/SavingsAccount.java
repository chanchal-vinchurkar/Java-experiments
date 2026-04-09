public class SavingsAccount extends Account {
    private double interestRate;
    private double minimumBalance;

    public SavingsAccount(Customer customer, String accNo, double balance,
                          double interestRate, double minBalance) {
        super(customer, accNo, balance, "Savings");
        this.interestRate = interestRate;
        this.minimumBalance = minBalance;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount.");
            return;
        }
        if (balance - amount < minimumBalance) {
            System.out.println("Minimum balance must be maintained.");
        } else {
            balance -= amount;
            System.out.println("Savings Withdrawn: " + amount);
        }
    }

    public void applyInterest() {
        double interest = balance * interestRate / 100;
        balance += interest;
        System.out.println("Interest added: " + interest);
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Interest Rate: " + interestRate + "%");
        System.out.println("Minimum Balance: " + minimumBalance);
    }
}