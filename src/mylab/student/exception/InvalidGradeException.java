package mylab.student.exception;

// 학년 범위를 벗어났을 때 발생하는 예외 클래스
public class InvalidGradeException extends Exception {
    public InvalidGradeException(String message) {
        super(message);
    }
}