package com.fly.test.mapstruct;

public class Test {

    public static void main(String[] args) {
        Student student = new Student("诸葛亮", 22);
        Teacher teacher = new Teacher("司马懿", 35);
        StudentVO studentVO = StudentMapper.INSTANCE.toStudentVO(student, teacher);
        System.out.println(studentVO);
    }

}