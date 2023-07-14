package dev.bank;

import java.util.HashMap;
import java.util.Map;

public class Bank {
    int routingNumber;
    long lastTransactionId;
    Map<String, Customer> customers = new HashMap<>();


    public String addCustomer (String name, double initialDepositCheckings, double initialDepositSavings) {
        Customer newCustomer = new Customer(name);
        String customerId = newCustomer.getCustomerId();
        customers.put(customerId, newCustomer);
        newCustomer.addBankAccount(Account.AccountType.CHECKING, initialDepositCheckings);
        newCustomer.addBankAccount(Account.AccountType.SAVINGS, initialDepositSavings);
        System.out.println("Customer added: " + newCustomer.getName() + " with ID: " + customerId);
        System.out.println("Checking account added with balance: " + newCustomer.getAccountByType(Account.AccountType.CHECKING).getBalance());
        System.out.println("Savings account added with balance: " + newCustomer.getAccountByType(Account.AccountType.SAVINGS).getBalance());

        return customerId;
    }

    public void doTransaction (String customerId, Account.AccountType accountType, double amount) {
        Customer customer = getCustomerById(customerId);
        Account account = customer.getAccountByType(accountType);

        // validate that the account cannot go below 0
        if (account.getBalance() + amount < 0) {
            throw new IllegalArgumentException("Insufficient funds");
        }
        account.commitTransaction(routingNumber, ++lastTransactionId, customerId, amount);
        System.out.println("Transaction completed: " + accountType + " with balance: " + account.getBalance());


        // get customer
        // get account
        // commit transaction

    }

    public Customer getCustomerById (String id) {
        Customer customer = customers.get(id);
        if (customer == null) {
            throw new IllegalArgumentException("Customer not found");
        }
        String customerName = customer.getName();
        // return new Customer(customerName); this returned a new customer with new ID
        return customer;
    };

}
