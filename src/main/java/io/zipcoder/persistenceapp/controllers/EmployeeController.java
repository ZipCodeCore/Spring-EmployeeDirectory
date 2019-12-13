package io.zipcoder.persistenceapp.controllers;

import io.zipcoder.persistenceapp.entities.Employee;
import io.zipcoder.persistenceapp.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

        EmployeeService employeeService;

        @Autowired
        public EmployeeController(EmployeeService employeeService){
            this.employeeService = employeeService;
        }

        @GetMapping
        public ResponseEntity<Iterable<Employee>> getAllEmployees(){
            return null;
        }

    //   TODO
    /*


    * create employee
    * update employee to set their manager
    * get a list of employees under a particular manager
    * get the entire hierarchy for an employee (manager, manager's manager..)
    * list of employees without a manager
    * list of employees under a particular department
    * remove an employee
    * remove a list of employees
    * remove all employees from a department
    * remove all employees under a particular manager
    * merge departments: given two department names eg: A and B, move the manager of B to report to the manager of A,
        and update all other employees to be members of department A
    * remove all direct reports to a manager. Any employees previously managed by the deleted employees
        should now be managed by the next manager up the hierarchy.

     */
}
