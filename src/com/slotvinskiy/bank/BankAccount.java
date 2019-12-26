package com.slotvinskiy.bank;

public class BankAccount {

    private String name;
    private double count;
    public static double bankCount;

    public BankAccount(String name, double count) {
        this.name = name;
        this.count = count;
    }

    public static void setBankCount(double bankCount) {
        BankAccount.bankCount = bankCount;
    }

    public static double getBankCount() {
        return bankCount;
    }

       public double getCount() {
        return count;
    }

    public void setCount(double count) {
        this.count = count;
    }

    // 0.5% commission
    public void add(double money) {
        this.count = this.count + money * 0.995;
        setBankCount(getBankCount() + money * 0.005);
    }

    // 1% commission
    public void transfer(BankAccount otherPerson, double money){
        this.count = this.count - money;
        otherPerson.setCount(money * 0.99);
        setBankCount(getBankCount() + money * 0.01);
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "name='" + name + '\'' +
                ", count=" + count +
                ", bank " + bankCount +
                '}';
    }
}