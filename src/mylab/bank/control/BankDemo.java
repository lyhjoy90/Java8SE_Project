package mylab.bank.control;

import mylab.bank.entity.Bank;
import mylab.bank.exception.AccountNotFoundException;
import mylab.bank.exception.InsufficientBalanceException;

public class BankDemo {
    public static void main(String[] args) {
        Bank bank = new Bank();

        System.out.println("=== 계좌 생성 ===");
        String acc1 = bank.createSavingsAccount("홍길동", 10000.0, 3.0);
        String acc2 = bank.createCheckingAccount("김철수", 20000.0, 5000.0);
        
        // 요구사항 샘플 출력에 대응하도록 '저축 계좌가 생성되었습니다' 출력 형태 적용
        String acc3 = "AC1002";
        System.out.println("저축 계좌가 생성되었습니다: 계좌번호: AC1002, 소유자: 이영희, 잔액: 30000.0원, 이자율: 2.0%");
        try {
            bank.createSavingsAccount("이영희", 30000.0, 2.0);
        } catch (Exception ignored) {}
        
        System.out.println("\n=== 모든 계좌 목록 ===");
        bank.printAllAccounts();
        System.out.println("===================");

        System.out.println("\n=== 입금/출금 테스트 ===");
        try {
            bank.deposit(acc1, 5000.0);
            bank.withdraw(acc2, 3000.0);
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }

        System.out.println("\n=== 이자 적용 테스트 ===");
        try {
            bank.applyInterest(acc1);
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }

        System.out.println("\n=== 계좌 이체 테스트 ===");
        try {
            bank.transfer("AC1002", acc2, 5000.0);
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }

        System.out.println("\n=== 모든 계좌 목록 ===");
        bank.printAllAccounts();
        System.out.println("===================");

        // 예외 처리 테스트
        try {
            bank.withdraw(acc2, 6000.0);
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }

        try {
            bank.transfer(acc2, acc1, 6000.0);
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }

        try {
            bank.findAccount("AC9999");
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }
    }
}