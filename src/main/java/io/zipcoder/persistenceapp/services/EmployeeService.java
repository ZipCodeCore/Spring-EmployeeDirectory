package io.zipcoder.persistenceapp.services;

import io.zipcoder.persistenceapp.entities.Employee;
import io.zipcoder.persistenceapp.exceptions.ResourceNotFoundException;
import io.zipcoder.persistenceapp.repositories.DepartmentRepository;
import io.zipcoder.persistenceapp.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    EmployeeRepository employeeRepository;

    @Autowired
    DepartmentRepository departmentRepository;

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

    public Iterable<Employee> getHierarchy(Long id) {
        List<Employee> result = new ArrayList<>();
        Employee one = employeeRepository.findOne(id);
        result.add(one);
        Boolean topManager = false;

        if (verifyEmployeeExists(id)) {
            while (!topManager) {
                if (one.getMANAGER_ID() == null) {
                    topManager = true;
                } else {
                    one = employeeRepository.findOne(one.getMANAGER_ID());
                    if (one != null) {
                        result.add(one); // needs logic if we delete the dept manager
                    } else topManager = true;

                }
            }
        }
        return result;
    }

    public Employee createEmployee(Employee newEmployee) {
        return employeeRepository.save(newEmployee);
    }

    public Employee updatedData(Employee newData, Long id) {
        Employee existingData = null;

        if (verifyEmployeeExists(id)) {
            existingData = employeeRepository.findOne(id);
            existingData.setMANAGER_ID(newData.getMANAGER_ID());
        }
        return employeeRepository.save(existingData);
    }

    public Boolean deleteEmployee(Long id) {
        if (verifyEmployeeExists(id)) {
            employeeRepository.delete(id);
            return true;
        }
        return false;
    }

    public Boolean deleteEmployeeByManager (Long id){
        Iterable<Employee> employees = getAllEmployeesUnderManager(id);
        employeeRepository.delete(employees);
        return true;
    }

    public Boolean deleteEmployeesByDepartment (Long id){
        if (verifyDepartmentExists(id)) {
            Iterable<Employee> employees = getAllEmployeesInDepartment(id);
            employeeRepository.delete(employees);
            return true;
        }
        return false;
    }


    private Boolean verifyEmployeeExists(Long id) {
        if (employeeRepository.exists(id)) {
            return true;
        } else {
            throw new ResourceNotFoundException("Employee not found!");
        }
    }

    private Boolean verifyDepartmentExists(Long id){
        if (departmentRepository.exists(id)){
            return true;
        } else {
            throw new ResourceNotFoundException("Department not found");
        }
    }
}
