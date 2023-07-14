package dev.bank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Customer {
    private final int id;
    private final String name;
    ArrayList<Account> accounts;

    private static int lastCustomerId = 0;

    Customer(String name) {
        this.id = lastCustomerId + 1;
        this.name = name;
        this.accounts = new ArrayList<>();
        lastCustomerId++;
    }

    void addBankAccount(Account.AccountType accountType, double initilDeposit) {
        Account account = new Account(accountType, initilDeposit);
        System.out.println("Account added: " + account.getAccountType() + " with balance: " + account.getBalance());
        accounts.add(account);
    }

    @Override
    public String toString() {
        String[]accounts = new String[this.accounts.size()];
        Arrays.setAll(accounts, i -> this.accounts.get(i).toString());
        return "%015d %s %s".formatted(id, name, String.join(", ", accounts));

    }

    String getCustomerId() {
        return String.format("%015d", id);
    }

    public List<Account> getAccounts () {
        // return new ArrayList<>(Collections.unmodifiableList(accounts));
        return new ArrayList<>(accounts);
    }

    public Account getAccountByType (Account.AccountType accountType) {
        for (Account account : accounts) {
            if (account.getAccountType() == accountType) {
                return account;
            }
        }
        throw new IllegalArgumentException("Account not found");
    }

    String getName() {
        return name;
    }
}
