package com.fly.test.lombok;

import org.junit.Test;

public class LombokTest {

    @Test
    public void testUser(){
        User user = new User();
        user.setName("AnyCode");
        user.setAge(20);
        System.err.println(user.toString());
    }

    @Test
    public void testStudent() {
        Student student = new Student("test", 12, "1", 12);
        System.out.println(student.toString());
    }

    @Test
    public void testPeople(){
        People people = new People("people", 12);
        System.err.println(people.toString());
    }

}
