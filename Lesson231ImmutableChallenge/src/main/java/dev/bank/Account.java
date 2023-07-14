package dev.bank;

import dev.dto.Transaction;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Account {

    public enum AccountType {
        SAVINGS, CHECKING
    }

    private final AccountType accountType;
    private double balance;

    Map<Long, Transaction> transactions;

    public double getBalance() {
        return balance;
    }

    public Account(AccountType accountType, double initialDeposit) {
        this.accountType = accountType;
        this.balance = initialDeposit;
        this.transactions = new HashMap<>();
    }

    AccountType getAccountType() {
        return accountType;
    }


    @Override
    public String toString() {
        return "%s $%.2f".formatted(accountType, balance);
    }

    public Map<Long, String> getTransactions() {
        // return new HashMap<>(Colálections.unmodifiableMap(transactions));
        // return Map.copyOf(transactions);

        // reutrn map of strings instead of transactions to prevent any modification of the transactions
        Map<Long, String> transactionStrings = new HashMap<>();
        for (Map.Entry<Long, Transaction> entry : transactions.entrySet()) {
            transactionStrings.put(entry.getKey(), entry.getValue().toString());
        }
        return transactionStrings;
    }

    void commitTransaction(int routingNumber, long transactionId, String customerId, double amount) {
        validateTransaction(amount);
        adjustBalance(amount);
        addTransaction(routingNumber, transactionId, customerId, amount);
    }

    private void addTransaction(int routingNumber, long transactionId, String customerId, double amount) {
        transactions.put(transactionId, new Transaction(routingNumber, customerId, transactionId, amount));
    }

    private void adjustBalance(double amount) {
        balance += amount;
    }

    private void validateTransaction(double amount) {
        if (balance + amount < 0) {
            throw new IllegalArgumentException("Insufficient funds");
        }
    }
}
