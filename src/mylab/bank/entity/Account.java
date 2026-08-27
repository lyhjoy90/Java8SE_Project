package mylab.bank.entity;

import mylab.bank.exception.InsufficientBalanceException;

// 계좌 기본 추상 클래스
public abstract class Account {
    private String accountNumber;
    private String ownerName;
    private double balance;

    public Account(String accountNumber, String ownerName, double balance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public double getBalance() {
        return balance;
    }

    protected void setBalance(double balance) {
        this.balance = balance;
    }

    // 입금
    public void deposit(double amount) {
        this.balance += amount;
    }

    // 출금
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException("잔액이 부족합니다. 현재 잔액: " + balance + "원");
        }
        this.balance -= amount;
    }

    @Override
    public String toString() {
        return "계좌번호: " + accountNumber + ", 소유자: " + ownerName + ", 잔액: " + balance + "원";
    }
}