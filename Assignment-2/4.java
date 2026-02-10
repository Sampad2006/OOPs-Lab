import java.util.*;

abstract class BankAccount {
    protected String accountNo;
    protected double balance;

    public BankAccount(String accountNo, double balance) {
        this.accountNo = accountNo;
        this.balance = balance;
    }

    public String getAccountNo() { return accountNo; }
    public abstract void calculateInterest();

    @Override
    public String toString() {
        return "Acc No: " + accountNo + " | Balance: " + balance;
    }
}

class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String accountNo, double balance, double interestRate) {
        super(accountNo, balance);
        this.interestRate = interestRate;
    }

    @Override
    public void calculateInterest() {
        double interest = balance * (interestRate / 100);
        System.out.println(">>> Projected Savings Interest: " + interest);
    }

    @Override
    public String toString() {
        return super.toString() + " (Type: Savings, Rate: " + interestRate + "%)";
    }
}

class CurrentAccount extends BankAccount {
    private double overdraftLimit;

    public CurrentAccount(String accountNo, double balance, double overdraftLimit) {
        super(accountNo, balance);
        this.overdraftLimit = overdraftLimit;
    }

    public void displayOverdraftAmount() {
        System.out.println(">>> Overdraft Limit: " + overdraftLimit);
    }

    @Override
    public void calculateInterest() {
        System.out.println(">>> Current Account: No interest.");
    }

    @Override
    public String toString() {
        return super.toString() + " (Type: Current, Overdraft: " + overdraftLimit + ")";
    }
}

public class BankSystem {
    private List<BankAccount> accounts = new ArrayList<>();

    public void addAccount(BankAccount acc) {
        accounts.add(acc);
        System.out.println("Account added successfully.");
    }

    public void verifyAccount(String accNo) {
        for (BankAccount acc : accounts) {
            if (acc.getAccountNo().equalsIgnoreCase(accNo)) {
                System.out.println("Account Found: " + acc);
                return;
            }
        }
        System.out.println("Account " + accNo + " not found.");
    }

    public void displayAll() {
        System.out.println("\nAll Account Records ->");
        for (BankAccount acc : accounts) {
            System.out.println(acc);
            acc.calculateInterest();
            if (acc instanceof CurrentAccount) {
                ((CurrentAccount) acc).displayOverdraftAmount();
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        BankSystem system = new BankSystem();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu");
            System.out.println("1. Add Savings Account");
            System.out.println("2. Add Current Account");
            System.out.println("3. Verify Account Existence");
            System.out.println("4. Display All Accounts");
            System.out.println("5. Exit");
            System.out.print("Enter Choice: ");
            
            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    System.out.print("Enter Account Number: "); String sNo = sc.nextLine();
                    System.out.print("Initial Balance: "); double sBal = sc.nextDouble();
                    System.out.print("Interest Rate : "); double sRate = sc.nextDouble();
                    system.addAccount(new SavingsAccount(sNo, sBal, sRate));
                    break;
                case 2:
                    System.out.print("Enter Account Number: "); String cNo = sc.nextLine();
                    System.out.print("Initial Balance: "); double cBal = sc.nextDouble();
                    System.out.print("Overdraft Limit: "); double cLimit = sc.nextDouble();
                    system.addAccount(new CurrentAccount(cNo, cBal, cLimit));
                    break;
                case 3:
                    System.out.print("Enter Account Number to verify: ");
                    system.verifyAccount(sc.nextLine());
                    break;
                case 4:
                    system.displayAll();
                    break;
                case 5:
                    System.out.println("Exiting System");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}