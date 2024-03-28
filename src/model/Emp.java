package model;

import java.util.Date;


public class Emp {

    private Long empNo;

    private String ename;

    private String efirst;

    private String job;

    private Emp mgr;

    private Date hireDate;

    private int sal;

    private int comm;

    private int tel;

    private Dept department;

    public Emp(Long empNo, String ename, String efirst, String job, Emp mgr, Date hireDate, int sal, int comm, int tel, Dept department) {
        this.empNo = empNo;
        this.ename = ename;
        this.efirst = efirst;
        this.job = job;
        this.mgr = mgr;
        this.hireDate = hireDate;
        this.sal = sal;
        this.comm = comm;
        this.tel = tel;
        this.department = department;
    }

    public Long getEmpNo() {
        return empNo;
    }

    public void setEmpNo(Long empNo) {
        this.empNo = empNo;
    }

    // … others getters/setters

    @Override
    public String toString() {
        return "Emp{" +
                "empNo=" + empNo +
                ", ename='" + ename + '\'' +
                ", efirst='" + efirst + '\'' +
                ", job='" + job + '\'' +
                ", mgr=" + mgr +
                ", hireDate=" + hireDate +
                ", sal=" + sal +
                ", comm=" + comm +
                ", tel=" + tel +
                ", department=" + department +
                '}';
    }
}
