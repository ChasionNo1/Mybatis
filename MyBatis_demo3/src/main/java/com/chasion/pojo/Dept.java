package com.chasion.pojo;

import java.util.List;

/**
 * @ClassName Dept
 * @Description TODO
 * @Author chasion
 * @Date 2022/4/18 19:44
 */
public class Dept {

    private Integer did;
    private String deptName;
    private List<Emp> emps;


    @Override
    public String toString() {
        return "Dept{" +
                "did=" + did +
                ", deptName='" + deptName + '\'' +
                ", emps=" + emps +
                '}';
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Dept(Integer did, String deptName) {
        this.did = did;
        this.deptName = deptName;
    }

    public List<Emp> getEmps() {
        return emps;
    }

    public void setEmps(List<Emp> emps) {
        this.emps = emps;
    }

    public Dept() {
    }
}
