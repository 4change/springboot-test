package com.fly.test.mapstruct;

public class Test {

    /**
     * <a href="https://blog.csdn.net/qq_40194399/article/details/110162124">MapStruct最详细的使用教程，别在用BeanUtils.copyProperties ()</a>
     * <a href="https://blog.csdn.net/zhujiakuan/article/details/121530650#t10">mapstruct 使用与问题解决</a>
     *
     * @param args
     */
    public static void main(String[] args) {
        Student student = new Student("诸葛亮", 22);
        Teacher teacher = new Teacher("司马懿", 35);
        StudentVO studentVO = StudentMapper.INSTANCE.toStudentVO(student, teacher);
        System.out.println(studentVO);
    }

}