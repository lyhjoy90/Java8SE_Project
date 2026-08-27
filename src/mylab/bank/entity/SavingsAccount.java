package mylab.bank.entity;

// 저축 계좌 (이자율 적용)
public class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(String accountNumber, String ownerName, double balance, double interestRate) {
        super(accountNumber, ownerName, balance);
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    // 이자 적용 메서드
    public double applyInterest() {
        double interest = getBalance() * (interestRate / 100.0);
        deposit(interest);
        return interest;
    }

    @Override
    public String toString() {
        return super.toString() + ", 이자율: " + interestRate + "%";
    }
}