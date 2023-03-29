import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Customer customerJohn = new Customer("John Brown");
        System.out.println(customerJohn);
        Bank bank = new Bank("Big Bank");
        System.out.println(bank);


        bank.addTransaction(customerJohn, 999.99);
        bank.addTransaction(customerJohn, -9.99);

        System.out.println(bank);
        System.out.println(customerJohn);

        bank.printStatement(customerJohn);






    }
}

class Customer{
    private String name;
    private ArrayList<Double> transactions = new ArrayList<Double>();

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }

    public void addTransaction(Double amount) {
        transactions.add(amount);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", transactions=" + transactions +
                '}';
    }
}

class Bank{
    private String name;
    private ArrayList<Customer> customers = new ArrayList<Customer>();

    public Bank(String name) {
        this.name = name;
//        this.customers =

    }

    public void addTransaction(Customer customer, Double amount) {
        // this doesnt belong here -> should be called transparently first
        addCustomerToListIfNotExists(customer);
        customer.addTransaction(amount);
    }

    public void printStatement(Customer customer) {
        System.out.printf("BANK STATEMENT FOR: %35s%n", customer.getName());
        System.out.println("-".repeat(55));
//        for  (Double transactionAmount : customer.getTransactions()){
        ArrayList<Double> customersTransactions = customer.getTransactions();
        for (int i = 0; i < customersTransactions.size(); i++) {
            System.out.printf("Transaction #%d amount: %32.2f%n", i+1, customersTransactions.get(i));
        }
    }

    private void addCustomerToListIfNotExists(Customer customer) {
        if (customers == null || !customers.contains(customer)){
            customers.add(new Customer(customer.getName()));
        }
    }

    @Override
    public String toString() {
        return "Bank{" +
                "name='" + name + '\'' +
                ", customers=" + customers +
                '}';
    }
}