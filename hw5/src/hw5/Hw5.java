/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author rs
 */
public class Hw5 {

    String[] args;

    Hw5(String[] _args) {
        args = _args;
    }

    public static void main(String[] args) throws Exception {
        new Hw5(args).run();
    }

    void run() throws Exception {
        ArrayList< Transaction> transactions = makeTransactions(10);
        
        System.out.println("\nShowing all transactions in account number order");
        transactions.forEach(
                transaction -> {
                    System.out.println(transaction);
                }
        );
        System.out.println("\nShowing all Transactions as occured");
        transactions.parallelStream().forEach(transaction -> {
            System.out.println(transaction);
        });
        System.out.println("\nShowing all Withdrawals");
        transactions.parallelStream().filter(transaction
                -> Double.parseDouble(transaction.amount.toString()) < 0)
                .forEach(transaction -> {
                    System.out.println(transaction);
                });

        
        Map<String, Double> accountBals = new HashMap<String, Double>();
        for (Transaction transaction : transactions) {
            try {
                accountBals.put(transaction.user, accountBals.get(transaction.user) + transaction.amount);
            } catch (NullPointerException ex) {
                accountBals.put(transaction.user, transaction.amount);
            }
        }
        System.out.println("\nUsers Remaining Balances:");
        for (Map.Entry<String, Double> entry : accountBals.entrySet()) {
            String user = entry.getKey();
            Double balance = entry.getValue();
            System.out.printf(user + "'s Balance: $" + "%.2f\n", balance);

        }

    }

    ArrayList< Transaction> makeTransactions(int n) {
        ArrayList< Transaction> transactions = new ArrayList< Transaction>();
        String[] users = {"Randy", "Nadine", "Crabman", "Joy", "Earl"};
        Double randomDouble;
        ThreadLocalRandom.current().nextDouble(-1000, 1000);
        for (int i = 0; i < n; ++i) {
            randomDouble = ThreadLocalRandom.current().nextDouble(-1000, 1000);
            transactions.add(new Transaction(i % users.length + 1001, users[i % users.length], Math.round(randomDouble * 100d) / 100d));
        }
        return transactions;
    }

}
