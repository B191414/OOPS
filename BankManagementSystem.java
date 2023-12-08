package bank;

interface Bank {
    boolean credentialsCheck(String username, String password);
    void credit(double amount);
    void debit(double amount) throws InsufficientFundsException;
    double displayBalance();
    void exit();
}

class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

public class BankManagementSystem implements Bank {
    private String username;
    private String password;
    private double balance;

    public BankManagementSystem(String username, String password, double initialBalance) {
        this.username = username;
        this.password = password;
        this.balance = initialBalance;
    }

    @Override
    public boolean credentialsCheck(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    @Override
    public void credit(double amount) {
        balance += amount;
        System.out.println("Credited: $" + amount);
    }

    @Override
    public void debit(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds. Available balance: $" + balance);
        }
        balance -= amount;
        System.out.println("Debited: $" + amount);
    }

    @Override
    public double displayBalance() {
        System.out.println("Current Balance: $" + balance);
        return balance;
    }

    @Override
    public void exit() {
        System.out.println("Exiting the Bank Management System. Thank you!");
        System.exit(0);
    }

    public static void main(String[] args) {
        BankManagementSystem bank = new BankManagementSystem("user123", "pass123", 1000);

        // Simulating user interactions
        if (bank.credentialsCheck("user123", "pass123")) {
            bank.credit(500);
            try {
                bank.debit(200);
                bank.displayBalance();
                bank.exit();
            } catch (InsufficientFundsException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } else {
            System.out.println("Invalid credentials.");
        }
    }
}

