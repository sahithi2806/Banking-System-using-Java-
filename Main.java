import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        BankService bank = new BankService();
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n===== BANKING SYSTEM =====");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Transfer");
            System.out.println("4. View All Transactions");
            System.out.println("5. Check Balance");
            System.out.println("6. Search Transactions by Amount");
            System.out.println("7. Previous Transactions");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            switch(choice) {
                case 1:
                    System.out.print("Enter amount: ");
                    bank.deposit(sc.nextDouble());
                    break;

                case 2:
                    System.out.print("Enter amount: ");
                    bank.withdraw(sc.nextDouble());
                    break;

                case 3:
                    System.out.print("Enter receiver name: ");
                    String receiver = sc.next();
                    System.out.print("Enter amount: ");
                    bank.transfer(receiver, sc.nextDouble());
                    break;

                case 4:
                    bank.viewTransactions();
                    break;

                case 5:
                    bank.checkBalance();
                    break;

                case 6:
                    System.out.print("Enter amount to search: ");
                    bank.searchByAmount(sc.nextDouble());
                    break;

                case 7:
                    System.out.print("Enter N: ");
                    bank.showLastTransactions(sc.nextInt());
                    break;

                case 8:
                    System.out.println("Exiting Banking System...");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 8);
        sc.close();
    }
}
