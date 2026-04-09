import java.util.ArrayList;

public class BankingApp {
    public static void main(String[] args) {

        ArrayList<Customer> customers = new ArrayList<>();
        ArrayList<Account> accounts = new ArrayList<>();

        // Customers
        Customer c1 = new Customer(101, "Rahul Verma", "rahul@mail.com", "9001122334");
        Customer c2 = new Customer(102, "Sneha Iyer", "sneha@mail.com", "9812345670");
        Customer c3 = new Customer(103, "Aditya Kulkarni", "aditya@mail.com", "9898989898");

        customers.add(c1);
        customers.add(c2);
        customers.add(c3);

        // Accounts
        accounts.add(new SavingsAccount(c1, "SA501", 75000.50, 5.0, 2000.0));
        accounts.add(new LoanAccount(c1, "LA601", 350000.75, 9.25, 72, "Car"));
        accounts.add(new SavingsAccount(c2, "SA502", 42000.25, 4.25, 1500.0));
        accounts.add(new LoanAccount(c3, "LA602", 150000.00, 11.5, 48, "Education"));

        // Transactions
        accounts.get(0).deposit(8000);
        accounts.get(0).withdraw(3000);

        ((SavingsAccount) accounts.get(0)).applyInterest();

        accounts.get(1).deposit(15000);
        accounts.get(2).deposit(5000);
        accounts.get(3).deposit(10000);

        // Report
        System.out.println("\n===== CUSTOMER ACCOUNT REPORT =====");

        for (Customer c : customers) {
            c.displayDetails();
            System.out.println("Accounts:");

            for (Account a : accounts) {
                if (a.getCustomer().getCustomerId() == c.getCustomerId()) {
                    a.displayDetails();
                    System.out.println();
                }
            }
            System.out.println("----------------------------");
        }
    }
}