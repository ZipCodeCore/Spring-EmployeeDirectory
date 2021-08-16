package io.zipcoder.persistenceapp.employee;

import org.springframework.web.bind.annotation.PathVariable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long employeeNum;
    private String firstName;
    private String lastName;
    private String title;
    private String phoneNumber;
    private String email;
    private String hireDate;
    private String managerName;
    private Integer depNum;

    public Employee() {
    }

    public Employee(Long employeeNum,
                    String firstName,
                    String lastName,
                    String title,
                    String phoneNumber,
                    String email,
                    String hireDate,
                    String managerName,
                    Integer depNum) {
        this.employeeNum = employeeNum;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.hireDate = hireDate;
        this.managerName = managerName;
        this.depNum = depNum;
    }

    public Long getEmployeeNum() {
        return employeeNum;
    }

    public void setEmployeeNum(Long employeeNum) {
        this.employeeNum = employeeNum;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public Integer getDepNum() {
        return depNum;
    }

    public void setDepNum(Integer depNum) {
        this.depNum = depNum;
    }
}
