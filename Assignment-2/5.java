import java.util.*;

class Customer {
    private final String customerId; 
    private String name;
    private String phoneNumber;
    protected double currentLoanAmount;
    
    public static double DEFAULT_LIMIT = 50000.0;

    public Customer(String customerId, String name, String phoneNumber) {
        this.customerId = customerId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.currentLoanAmount = 0.0;
    }

    // Getters and Seters
    public String getCustomerId() { return customerId; }
    public void setName(String name) { this.name = name; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    
    public double getCreditLimit() {
        return DEFAULT_LIMIT;
    }

    public double getRemainingCredit() {
        return getCreditLimit() - currentLoanAmount;
    }

    public boolean requestLoan(double amount) {
        if (currentLoanAmount + amount <= getCreditLimit()) {
            currentLoanAmount += amount;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Customer Name: " + name;
    }
    
    public void displayDetails() {
        System.out.println("ID: " + customerId + " | Name: " + name + " | Phone: " + phoneNumber);
        System.out.println("Current Loan: " + currentLoanAmount + " | Max Loan Possible: " + getRemainingCredit());
    }
}

class PrivilegedCustomer extends Customer {
    public static double PRIVILEGED_LIMIT = 150000.0;

    public PrivilegedCustomer(String customerId, String name, String phoneNumber) {
        super(customerId, name, phoneNumber);
    }

    @Override
    public double getCreditLimit() {
        return PRIVILEGED_LIMIT;
    }
}

public class BankLoanSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Customer> customers = new ArrayList<>();
        
        while (true) {
            System.out.println("\nBank Menu");
            System.out.println("1. Register Regular Customer\n2. Register Privileged Customer\n3. Request Loan\n4. Update Info\n5. Show All Customers\n6. Exit");
            System.out.print("Choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                case 2:
                    System.out.print("ID: "); String id = sc.nextLine();
                    System.out.print("Name: "); String name = sc.nextLine();
                    System.out.print("Phone: "); String phone = sc.nextLine();
                    if (choice == 1) customers.add(new Customer(id, name, phone));
                    else customers.add(new PrivilegedCustomer(id, name, phone));
                    break;

                case 3:
                    System.out.print("Enter Customer ID: ");
                    String loanId = sc.nextLine();
                    System.out.print("Loan Amount: ");
                    double amount = sc.nextDouble();
                    boolean found = false;
                    for (Customer c : customers) {
                        if (c.getCustomerId().equals(loanId)) {
                            if (c.requestLoan(amount)) System.out.println("Loan Sanctioned!");
                            else System.out.println("Loan Denied: Credit limit exceeded.");
                            found = true;
                            break;
                        }
                    }
                    if (!found) System.out.println("Customer not found.");
                    break;

                case 4:
                    System.out.print("Enter Customer ID: ");
                    String upId = sc.nextLine();
                    for (Customer c : customers) {
                        if (c.getCustomerId().equals(upId)) {
                            System.out.print("New Name: "); c.setName(sc.nextLine());
                            System.out.print("New Phone: "); c.setPhoneNumber(sc.nextLine());
                            break;
                        }
                    }
                    break;

                case 5:
                    for (Customer c : customers) {
                        System.out.println(c);
                        c.displayDetails();
                    }
                    break;

                case 6:
                    System.exit(0);
            }
        }
    }
}