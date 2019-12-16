package io.zipcoder.persistenceapp.controllers;

import io.zipcoder.persistenceapp.entities.Employee;
import io.zipcoder.persistenceapp.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/employee/")
public class EmployeeController {

    EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("allundermanager/{id}")
    public ResponseEntity<Iterable<Employee>> getAllEmployeesUnderManager(@PathVariable Long id) {
        return new ResponseEntity<>(employeeService.getAllEmployeesUnderManager(id), HttpStatus.OK);
    }

    @GetMapping("allindepartment/{id}")
    public ResponseEntity<Iterable<Employee>> getAllEmployeesInDepartment(@PathVariable Long id) {
        return new ResponseEntity<>(employeeService.getAllEmployeesInDepartment(id), HttpStatus.OK);
    }

    @GetMapping("allnomanager")
    public ResponseEntity<Iterable<Employee>> getAllEmployeesNoManager() {
        return new ResponseEntity<>(employeeService.getAllEmployeesNoManager(), HttpStatus.OK);
    }

    @GetMapping("hierarchy/{id}")
    public ResponseEntity<Iterable<Employee>> getHierarchy(@PathVariable Long id) {
        return new ResponseEntity<>(employeeService.getHierarchy(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Employee> createEmployee (@RequestBody Employee newEmployee){
        return new ResponseEntity<>(employeeService.createEmployee(newEmployee),HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Employee> updateManager (@RequestBody Employee updatedData, @PathVariable Long id){
        return new ResponseEntity<>(employeeService.updatedData(updatedData, id),HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> deleteEmployee (@PathVariable Long id){
        return new ResponseEntity<>(employeeService.deleteEmployee(id),HttpStatus.OK);
    }

    @DeleteMapping("manager/{id}")
    public ResponseEntity<Boolean> deleteEmployeeByManager(@PathVariable Long id){
        return new ResponseEntity<>(employeeService.deleteEmployeeByManager(id),HttpStatus.OK);
    }

    @DeleteMapping("department/{id}")
    public ResponseEntity<Boolean> deleteEmployeesByDepartment(@PathVariable Long id){
        return new ResponseEntity<>(employeeService.deleteEmployeesByDepartment(id), HttpStatus.OK);
    }

    @PutMapping("mergedepartment/{deptfrom}/{deptto}")
    public ResponseEntity<Iterable<Employee>> mergeDepartments(@PathVariable Long deptfrom, @PathVariable Long deptto){
        return new ResponseEntity<>(employeeService.mergeDepartments(deptfrom,deptto),HttpStatus.OK);
    }

    //   TODO
    /*

    * remove all direct reports to a manager. Any employees previously managed by the deleted employees
        should now be managed by the next manager up the hierarchy.

     */
}
