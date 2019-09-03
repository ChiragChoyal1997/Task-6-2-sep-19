package com.ioexamples;

import java.io.Serializable;

/**
 *
 * @author Chirag
 */
public class Employee implements Serializable{
    int eno;
    String ename;
    int sal;
    String desg;
    String dept;

    public Employee(int eno, String ename, int sal, String desg, String dept) {
        this.eno = eno;
        this.ename = ename;
        this.sal = sal;
        this.desg = desg;
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Employee{" + "eno=" + eno + ", ename=" + ename + ", sal=" + sal + ", desg=" + desg + ", dept=" + dept + '}';
    }
}
