package io.zipcoder.persistenceapp.department;

import io.zipcoder.persistenceapp.employee.Employee;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long depId;
    private String depName;
    private Employee depManager;

    public Department() {
    }

    public Department(Long depId, String depName, Employee depManager) {
        this.depId = depId;
        this.depName = depName;
        this.depManager = depManager;
    }

    public Long getDepId() {
        return depId;
    }

    public void setDepId(Long depId) {
        this.depId = depId;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public Employee getDepManager() {
        return depManager;
    }

    public void setDepManager(Employee depManager) {
        this.depManager = depManager;
    }
}
