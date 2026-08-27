package mylab.student.entity;

import mylab.student.exception.InvalidGradeException;

public class Student {
    // private 멤버 변수 선언
    private String studentId;
    private String name;
    private String major;
    private int grade;

    // 기본 생성자
    public Student() {}

    // 오버로딩 생성자
    public Student(String studentId, String name, String major, int grade) throws InvalidGradeException {
        this.studentId = studentId;
        this.name = name;
        this.major = major;
        setGrade(grade); // 학년 검증 로직 적용
    }

    // Getter / Setter
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getGrade() {
        return grade;
    }

    // 학년 설정 메서드 (1~4 범위를 벗어나면 예외 던짐)
    public void setGrade(int grade) throws InvalidGradeException {
        if (grade < 1 || grade > 4) {
            throw new InvalidGradeException("학년은 1-4 사이의 값이어야 합니다.");
        }
        this.grade = grade;
    }
}