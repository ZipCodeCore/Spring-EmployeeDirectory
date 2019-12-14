package io.zipcoder.persistenceapp.services;

import io.zipcoder.persistenceapp.entities.Employee;
import io.zipcoder.persistenceapp.exceptions.ResourceNotFoundException;
import io.zipcoder.persistenceapp.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Iterable<Employee> getAllEmployeesUnderManager(Long id) {
        List<Employee> allEmployees = new ArrayList<>();
        if (verifyEmployeeExists(id)) {
            for (Employee each : employeeRepository.findAll()) {
                if (each.getMANAGER_ID() == id) {
                    allEmployees.add(each);
                }
            }
        }
        return allEmployees;
    }

    public Iterable<Employee> getAllEmployeesInDepartment(Long id) {
        List<Employee> allEmployees = new ArrayList<>();

        if (verifyEmployeeExists(id)) {
            for (Employee each : employeeRepository.findAll()) {
                if (each.getDEPARTMENT_ID() == id) {
                    allEmployees.add(each);
                }
            }
        }
        return allEmployees;
    }

    public Iterable<Employee> getAllEmployeesNoManager() {
        List<Employee> allEmployees = new ArrayList<>();
        for (Employee each : employeeRepository.findAll()) {
            if (each.getMANAGER_ID() == null) {
                allEmployees.add(each);
            }
        }
        return allEmployees;
    }

    public Iterable<Employee> getHierarchy (Long id){
        List<Employee> result = new ArrayList<>();
        Employee one = employeeRepository.findOne(id);
        result.add(one);
        Boolean topManager = false;

        if (verifyEmployeeExists(id)){
            while (!topManager){
                if (one.getMANAGER_ID() == null){
                    topManager = true;
                } else {
                    one = employeeRepository.findOne(one.getMANAGER_ID());
                    result.add(one);
                }
            }
        }
        return result;
    }


    private Boolean verifyEmployeeExists(Long id) {
        if (employeeRepository.exists(id)) {
            return true;
        } else {
            throw new ResourceNotFoundException("Employee not found!");
        }
    }
}
