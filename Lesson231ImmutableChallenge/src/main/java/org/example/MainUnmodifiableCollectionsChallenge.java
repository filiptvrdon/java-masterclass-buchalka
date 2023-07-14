package org.example;

import dev.bank.Account;
import dev.bank.Bank;
import dev.bank.Customer;

public class MainUnmodifiableCollectionsChallenge {


    public static void main(String[] args) {
        Bank bank = new Bank();
        String newCustomerId = bank.addCustomer("John Doe", 100, 100);
        Customer customer = bank.getCustomerById(newCustomerId);
        System.out.println(customer);


        customer.getAccounts().stream()
                .map(Account::getBalance)
                .forEach(System.out::println);

        // customer.getAccounts().get(0).commitTransaction(bank.routingNumber, ++bank.lastTransactionId, newCustomerId, -100);
        bank.doTransaction(newCustomerId, Account.AccountType.CHECKING, -150);



    }


}
