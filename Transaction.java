public class Transaction {
    private String time;
    private String sender;
    private String receiver;
    private double amount;

    Transaction next; // for linked list

    public Transaction(String time, String sender, String receiver, double amount) {
        this.time = time;
        this.sender = sender;
        this.receiver = receiver;
        this.amount = amount;
        this.next = null;
    }

    public String getTime() { return time; }
    public String getSender() { return sender; }
    public String getReceiver() { return receiver; }
    public double getAmount() { return amount; }
}
