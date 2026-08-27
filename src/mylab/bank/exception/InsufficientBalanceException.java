package mylab.bank.exception;

// 잔액 부족 시 발생
public class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}