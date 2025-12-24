import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BankService {
    private Transaction head = null;
    private double balance = 0.0;
    private String getCurrentTime() {
        return LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    private void addTransaction(String sender, String receiver, double amount) {
        Transaction t = new Transaction(getCurrentTime(), sender, receiver, amount);
        t.next = head;
        head = t;
    }

    public void deposit(double amount) {
        balance += amount;
        addTransaction("SELF", "SELF", amount);
        System.out.println("Deposit successful. Balance: " + balance);
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance!");
            return;
        }
        balance -= amount;
        addTransaction("SELF", "CASH", amount);
        System.out.println("Withdrawal successful. Balance: " + balance);
    }

    public void transfer(String receiver, double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance!");
            return;
        }
        balance -= amount;
        addTransaction("SELF", receiver, amount);
        System.out.println("Transfer successful. Balance: " + balance);
    }

    public void viewTransactions() {
        System.out.println("\n------------- TRANSACTION HISTORY -------------");
        Transaction temp = head;
        if (temp == null) {
            System.out.println("No transactions found.");
            return;
        }
        while (temp != null) {
            System.out.println("Time     : " + temp.getTime());
            System.out.println("Sender   : " + temp.getSender());
            System.out.println("Receiver : " + temp.getReceiver());
            System.out.println("Amount   : " + temp.getAmount());
            System.out.println("---------------------------------------------");
            temp = temp.next;
        }
    }
    public void checkBalance() {
        System.out.println("Current balance: " + balance);
    }
}
