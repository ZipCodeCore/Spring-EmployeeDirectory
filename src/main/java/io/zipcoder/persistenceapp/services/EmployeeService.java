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
    public EmployeeService (EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    public Iterable<Employee> getAllEmployeesUnderManager (Long id){
        verifyEmployeeExists(id);
        List<Employee> allEmployees = new ArrayList<>();
        for (Employee each : employeeRepository.findAll()){
            if (each.getMANAGER_ID()==id){
                allEmployees.add(each);
            }
        }
        return allEmployees;
    }

    private void verifyEmployeeExists(Long id){
        if (employeeRepository.exists(id)){

        }else
        {
            throw new ResourceNotFoundException("Employee not found!");
        }
    }
}
