package ru.itmo.lessons.lesson26;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        Account account01 = new Account(1, 100);
        Account account02 = new Account(2, 1000);
        Account account03 = new Account(3, 700);
        Account account04 = new Account(4, 900);

        ArrayList<Account> accounts = new ArrayList<>();
        accounts.add(account01);
        accounts.add(account02);
        accounts.add(account03);
        accounts.add(account04);

        Bank bank = new Bank();

        int ind1, ind2, sum;

        for (int i = 0; i < 10; i++) {
            ind1 = (int) (Math.random() * 3);
            sum = (int) (Math.random() * 500);
            if (ind1 > 0) ind2 = ind1-1;
            else ind2 = ind1 + 1;
            System.out.println((i+1) + ". id=" + accounts.get(ind1).getId() +
                    " переводит id=" + accounts.get(ind2).getId() + " сумму=" + sum);
            bank.transferMoney(accounts.get(ind1), accounts.get(ind2), sum);
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("Ошибка");
        }

        System.out.println("ИТОГО:");
        System.out.println("Баланс аккаунта 1 = " + account01.getBalance());
        System.out.println("Баланс аккаунта 2 = " + account02.getBalance());
        System.out.println("Баланс аккаунта 3 = " + account03.getBalance());
        System.out.println("Баланс аккаунта 4 = " + account04.getBalance());
    }



}
