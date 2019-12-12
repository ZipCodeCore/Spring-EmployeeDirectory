package io.zipcoder.persistenceapp.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long EMPLOYEE_ID;

    private String FIRST_NAME;
    private String LAST_NAME;
    private String TITLE;
    private String PHONE;
    private Date HIRE_DATE;
    private Boolean MANAGER;
    private Long DEPARTMENT_ID;


    public Long getEMPLOYEE_ID() {
        return EMPLOYEE_ID;
    }

    public String getFIRST_NAME() {
        return FIRST_NAME;
    }

    public void setFIRST_NAME(String FIRST_NAME) {
        this.FIRST_NAME = FIRST_NAME;
    }

    public String getLAST_NAME() {
        return LAST_NAME;
    }

    public void setLAST_NAME(String LAST_NAME) {
        this.LAST_NAME = LAST_NAME;
    }

    public String getTITLE() {
        return TITLE;
    }

    public void setTITLE(String TITLE) {
        this.TITLE = TITLE;
    }

    public String getPHONE() {
        return PHONE;
    }

    public void setPHONE(String PHONE) {
        this.PHONE = PHONE;
    }

    public Date getHIRE_DATE() {
        return HIRE_DATE;
    }

    public void setHIRE_DATE(Date HIRE_DATE) {
        this.HIRE_DATE = HIRE_DATE;
    }

    public Boolean getMANAGER() {
        return MANAGER;
    }

    public void setMANAGER(Boolean MANAGER) {
        this.MANAGER = MANAGER;
    }

    public Long getDEPARTMENT_ID() {
        return DEPARTMENT_ID;
    }

    public void setDEPARTMENT_ID(Long DEPARTMENT_ID) {
        this.DEPARTMENT_ID = DEPARTMENT_ID;
    }
}
