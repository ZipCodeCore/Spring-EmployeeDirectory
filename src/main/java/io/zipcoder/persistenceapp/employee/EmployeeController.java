package io.zipcoder.persistenceapp.employee;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class EmployeeController {

    @Autowired
    EmployeeService service;

    @PostMapping("/employee/create")
    public ResponseEntity<Employee> create(
            @RequestBody Employee employee) {
        return new ResponseEntity<>(service.create(employee), HttpStatus.CREATED);
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> findById(
            @PathVariable Long id) {
        return new ResponseEntity<>(service.read(id), HttpStatus.OK);
    }

    @GetMapping("/employee/employees")
    public ResponseEntity<Iterable<Employee>> findAll() {
        return new ResponseEntity<>(service.readAll(), HttpStatus.OK);
    }

    @PutMapping("/employee/update/{id}")
    public ResponseEntity<Employee> updateFields(
            @PathVariable Long id,
            @RequestBody Employee employee) {
        return new ResponseEntity<>(service.updateFields(id, employee), HttpStatus.OK);
    }

    @DeleteMapping("/employee/delete/{id}")
    public ResponseEntity<Employee> delete(
            @PathVariable Long id) {
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }

}
