package com.fly.test.lombok;

public class Student {

    private String stuName;
    private Integer stuAge;
    private String stuClass;
    private Integer stuNumber;

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public Integer getStuAge() {
        return stuAge;
    }

    public void setStuAge(Integer stuAge) {
        this.stuAge = stuAge;
    }

    public String getStuClass() {
        return stuClass;
    }

    public void setStuClass(String stuClass) {
        this.stuClass = stuClass;
    }

    public Integer getStuNumber() {
        return stuNumber;
    }

    public void setStuNumber(Integer stuNumber) {
        this.stuNumber = stuNumber;
    }

    public Student(String stuName, Integer stuAge, String stuClass, Integer stuNumber) {
        this.stuName = stuName;
        this.stuAge = stuAge;
        this.stuClass = stuClass;
        this.stuNumber = stuNumber;
    }
}
