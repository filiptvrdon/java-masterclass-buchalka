package sk.filiptvrdon;

public class Main {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount("12345-678", 1000.00);

        // create new thread and call bankAccount.deposit(1000)
        Thread thread1 = new Thread() {
            public void run() {
                bankAccount.deposit(300);
                bankAccount.withdraw(50);
            }
        };

        Thread thread2 = new Thread() {
            public void run() {
                bankAccount.deposit(203.75);
                bankAccount.withdraw(100);
            }
        };

        thread1.start();
        thread2.start();

        System.out.println("Balance: " + bankAccount.getBalance());


    }
}