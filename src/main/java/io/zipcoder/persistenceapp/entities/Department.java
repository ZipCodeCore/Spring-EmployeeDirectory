package io.zipcoder.persistenceapp.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long DEPARTMENT_ID;

    private String DEPARTMENT_NAME;
    private Long DEPARTMENT_MANAGER;


    public Long getDEPARTMENT_ID() {
        return DEPARTMENT_ID;
    }


    public String getDEPARTMENT_NAME() {
        return DEPARTMENT_NAME;
    }

    public void setDEPARTMENT_NAME(String DEPARTMENT_NAME) {
        this.DEPARTMENT_NAME = DEPARTMENT_NAME;
    }

    public Long getDEPARTMENT_MANAGER() {
        return DEPARTMENT_MANAGER;
    }

    public void setDEPARTMENT_MANAGER(Long DEPARTMENT_MANAGER) {
        this.DEPARTMENT_MANAGER = DEPARTMENT_MANAGER;
    }
}
