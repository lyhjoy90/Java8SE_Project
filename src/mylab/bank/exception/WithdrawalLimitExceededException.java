package mylab.bank.exception;

// 출금 한도 초과 시 발생 (InsufficientBalanceException 상속)
public class WithdrawalLimitExceededException extends InsufficientBalanceException {
    public WithdrawalLimitExceededException(String message) {
        super(message);
    }
}