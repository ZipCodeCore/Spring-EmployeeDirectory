package io.zipcoder.persistenceapp.employee;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo repo;

    public Employee create(Employee person) {
        return repo.save(person);
    }

    public Employee read(Long id) {
        return repo.findOne(id);
    }

    public List<Employee> readAll() {
        Iterable<Employee> employeeIterable = repo.findAll();
        List<Employee> employees = new ArrayList<>();
        employeeIterable.forEach(employees::add);
        return employees;
    }

    public List<Employee> readOfManager(Employee managerName) {
        List<Employee> entireList = readAll();
        List<Employee> result = new ArrayList<>();
        entireList.forEach(employee -> {
            if (employee.getEmployeeNum().equals(managerName.getEmployeeNum())) {
                result.add(employee);
            }
        });
        return result;
    }

    // no update for hiredate/employee ID //// or DepKey (as of right now)
    public Employee updateFields(Long id, Employee em) {
        Employee inDb = read(id);
        inDb.setFirstName(em.getFirstName());
        inDb.setLastName(em.getLastName());
        inDb.setTitle(em.getTitle());
        inDb.setPhoneNumber(em.getPhoneNumber());
        inDb.setEmail(em.getEmail());
        inDb = repo.save(inDb);
        return inDb;
    }

    public Employee updateManager(Long id, Employee newManager) {
        Employee inDb = read(id);
        inDb.setManager(newManager);
        inDb = repo.save(inDb);
        return inDb;
    }

    public Employee delete(Long id) {
        Employee em = read(id);
        repo.delete(id);
        return em;
    }

    public Employee delete(Employee employee) {
        return delete(employee.getEmployeeNum());
    }

}
