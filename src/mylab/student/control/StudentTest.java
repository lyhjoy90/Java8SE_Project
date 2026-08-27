package mylab.student.control;

import mylab.student.entity.Student;
import mylab.student.exception.InvalidGradeException;

public class StudentTest {
    public static void main(String[] args) {
        try {
            // 학생 객체 생성 및 정상 출력
            Student student = new Student("202401", "김민수", "컴퓨터공학", 3);
            System.out.println(student.getName() + " / " + student.getMajor() + " / " + student.getGrade() + "학년");

            // 5학년 변경 시도 (예외 발생)
            System.out.println("5학년으로 변경");
            student.setGrade(5);

        } catch (InvalidGradeException e) {
            // 예외 메시지 출력
            System.out.println(e.getMessage());
        }
    }
}