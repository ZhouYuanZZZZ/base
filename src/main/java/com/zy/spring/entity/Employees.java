package com.zy.spring.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "employees")
public class Employees {
    @Id
    @Column(name = "EMPLOYEE_ID")
    private BigDecimal employeeId;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Column(name = "HIRE_DATE")
    private Date hireDate;

    @Column(name = "JOB_ID")
    private String jobId;

    @Column(name = "SALARY")
    private BigDecimal salary;

    @Column(name = "COMMISSION_PCT")
    private BigDecimal commissionPct;

    @Column(name = "MANAGER_ID")
    private BigDecimal managerId;

    @Column(name = "DEPARTMENT_ID")
    private BigDecimal departmentId;

    /**
     * @return EMPLOYEE_ID
     */
    public BigDecimal getEmployeeId() {
        return employeeId;
    }

    /**
     * @param employeeId
     */
    public void setEmployeeId(BigDecimal employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * @return FIRST_NAME
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName == null ? null : firstName.trim();
    }

    /**
     * @return LAST_NAME
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName == null ? null : lastName.trim();
    }

    /**
     * @return EMAIL
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * @return PHONE_NUMBER
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param phoneNumber
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber == null ? null : phoneNumber.trim();
    }

    /**
     * @return HIRE_DATE
     */
    public Date getHireDate() {
        return hireDate;
    }

    /**
     * @param hireDate
     */
    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    /**
     * @return JOB_ID
     */
    public String getJobId() {
        return jobId;
    }

    /**
     * @param jobId
     */
    public void setJobId(String jobId) {
        this.jobId = jobId == null ? null : jobId.trim();
    }

    /**
     * @return SALARY
     */
    public BigDecimal getSalary() {
        return salary;
    }

    /**
     * @param salary
     */
    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    /**
     * @return COMMISSION_PCT
     */
    public BigDecimal getCommissionPct() {
        return commissionPct;
    }

    /**
     * @param commissionPct
     */
    public void setCommissionPct(BigDecimal commissionPct) {
        this.commissionPct = commissionPct;
    }

    /**
     * @return MANAGER_ID
     */
    public BigDecimal getManagerId() {
        return managerId;
    }

    /**
     * @param managerId
     */
    public void setManagerId(BigDecimal managerId) {
        this.managerId = managerId;
    }

    /**
     * @return DEPARTMENT_ID
     */
    public BigDecimal getDepartmentId() {
        return departmentId;
    }

    /**
     * @param departmentId
     */
    public void setDepartmentId(BigDecimal departmentId) {
        this.departmentId = departmentId;
    }
}