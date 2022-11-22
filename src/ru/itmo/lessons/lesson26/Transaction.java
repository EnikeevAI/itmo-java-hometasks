package ru.itmo.lessons.lesson26;

public class Transaction implements Runnable{
    private Account src; // с какого аккаунта осуществлять перевод
    private Account dst; // на какой аккаунт осуществлять перевод
    private int money; // сколько переводить

    public Transaction(Account src, Account dst, int money) {
        this.src = src;
        this.dst = dst;
        this.money = money;
    }

    private synchronized boolean getSrcMoney() {
        if (src.getBalance() < money) {
            System.out.println("Сумма: " + money + " НЕ списана у пользователя с id= "+ src.getId() +". Баланс: " + src.getBalance());
            return false;
        }
        int minusMoney = src.getBalance() - money;
        src.setBalance(minusMoney);
        System.out.println("Сумма: " + money + " списана у пользователя с id= "+ src.getId() +". Баланс: " + src.getBalance());
        return true;
    }

    private synchronized void addDstMoney() {
        int resultMoney = dst.getBalance() + money;
        dst.setBalance(resultMoney);
        System.out.println("Сумма: " + money + " поступила пользователю с id="+ dst.getId() +". Баланс: " + dst.getBalance());
    }

    @Override
    public void run() {
        if (getSrcMoney()) addDstMoney();
    }
}