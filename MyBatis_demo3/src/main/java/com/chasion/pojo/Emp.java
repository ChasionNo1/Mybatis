package com.chasion.pojo;

import java.io.Serializable;

/**
 * @ClassName Emp
 * @Description TODO
 * @Author chasion
 * @Date 2022/4/18 19:44
 */
public class Emp implements Serializable {
    private Integer id;
    private String empName;
    private Integer age;
    private String sex;
    private String email;
    private Dept dept;


    public Emp() {
    }

    public Dept getDept() {
        return dept;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", empName='" + empName + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", email='" + email + '\'' +
                ", dept=" + dept +
                '}';
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public Emp(Integer id, String empName, Integer age, String sex, String email) {
        this.id = id;
        this.empName = empName;
        this.age = age;
        this.sex = sex;
        this.email = email;
    }

    public Emp(Integer id, String empName, Integer age, String sex, String email, Dept dept) {
        this.id = id;
        this.empName = empName;
        this.age = age;
        this.sex = sex;
        this.email = email;
        this.dept = dept;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
