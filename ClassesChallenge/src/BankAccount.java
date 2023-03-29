public class BankAccount {

    long accountNumber;
    String customerName;
    String customerEmail;
    String customerPhoneNumber;
    double accountBalance;


    public BankAccount(long accountNumber, String customerEmail, String customerName, String customerPhoneNumber, double accountBalance){
        System.out.println("Account constructor with params called");
        this.accountNumber = accountNumber;
        this.customerEmail = customerEmail;
        this. customerName = customerName;
        this.customerPhoneNumber = customerPhoneNumber;
        this.accountBalance = accountBalance;
    }


    public long getAccountNumber() {
        return accountNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public String getPhoneNumber() {
        return customerPhoneNumber;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.customerPhoneNumber = phoneNumber;
    }


    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public double makeDeposit(double depositValue){
        double currentBalance = getAccountBalance();
        double newBalance =  currentBalance + depositValue;
        setAccountBalance(newBalance);
        return newBalance;
    }

    public double makeWithdrawal (double withdrawalValue){
        double currentBalance = getAccountBalance();
        double newBalance = currentBalance - withdrawalValue;
        if (newBalance <0) return -1.00;
        return newBalance;
    }
}
