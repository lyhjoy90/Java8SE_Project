package mylab.bank.entity;

import mylab.bank.exception.AccountNotFoundException;
import mylab.bank.exception.InsufficientBalanceException;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Account> accounts;
    private int nextAccountNumber;

    public Bank() {
        this.accounts = new ArrayList<>();
        this.nextAccountNumber = 1000;
    }

    // 저축 계좌 생성
    public String createSavingsAccount(String ownerName, double balance, double interestRate) {
        String accountNumber = "AC" + nextAccountNumber++;
        SavingsAccount acc = new SavingsAccount(accountNumber, ownerName, balance, interestRate);
        accounts.add(acc);
        System.out.println("Saving(저축) 계좌가 생성되었습니다: " + acc);
        return accountNumber;
    }

    // 체킹 계좌 생성
    public String createCheckingAccount(String ownerName, double balance, double withdrawalLimit) {
        String accountNumber = "AC" + nextAccountNumber++;
        CheckingAccount acc = new CheckingAccount(accountNumber, ownerName, balance, withdrawalLimit);
        accounts.add(acc);
        System.out.println("체킹 계좌가 생성되었습니다: " + acc);
        return accountNumber;
    }

    // 계좌 검색
    public Account findAccount(String accountNumber) throws AccountNotFoundException {
        for (Account acc : accounts) {
            if (acc.getAccountNumber().equals(accountNumber)) {
                return acc;
            }
        }
        throw new AccountNotFoundException("계좌번호 " + accountNumber + "에 해당하는 계좌를 찾을 수 없습니다.");
    }

    // 입금
    public void deposit(String accountNumber, double amount) throws AccountNotFoundException {
        Account acc = findAccount(accountNumber);
        acc.deposit(amount);
        System.out.println(amount + "원이 입금되었습니다. 현재 잔액: " + acc.getBalance() + "원");
    }

    // 출금
    public void withdraw(String accountNumber, double amount) throws AccountNotFoundException, InsufficientBalanceException {
        Account acc = findAccount(accountNumber);
        acc.withdraw(amount);
        System.out.println(amount + "원이 출금되었습니다. 현재 잔액: " + acc.getBalance() + "원");
    }

    // 이체
    public void transfer(String fromAccNum, String toAccNum, double amount) throws AccountNotFoundException, InsufficientBalanceException {
        Account fromAcc = findAccount(fromAccNum);
        Account toAcc = findAccount(toAccNum);

        fromAcc.withdraw(amount);
        System.out.println(amount + "원이 출금되었습니다. 현재 잔액: " + fromAcc.getBalance() + "원");

        toAcc.deposit(amount);
        System.out.println(amount + "원이 입금되었습니다. 현재 잔액: " + toAcc.getBalance() + "원");

        System.out.println(amount + "원이 " + fromAccNum + "에서 " + toAccNum + "로 송금되었습니다.");
    }

    // 이자 적용
    public void applyInterest(String accountNumber) throws AccountNotFoundException {
        Account acc = findAccount(accountNumber);
        if (acc instanceof SavingsAccount) {
            double interest = ((SavingsAccount) acc).applyInterest();
            System.out.println(interest + "원이 입금되었습니다. 현재 잔액: " + acc.getBalance() + "원");
            System.out.println("이자 " + interest + "원이 적용되었습니다. 현재 잔액: " + acc.getBalance() + "원");
        }
    }

    // 모든 계좌 목록 출력
    public void printAllAccounts() {
        for (Account acc : accounts) {
            System.out.println(acc);
        }
    }
}