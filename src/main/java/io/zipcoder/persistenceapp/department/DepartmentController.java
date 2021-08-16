package io.zipcoder.persistenceapp.department;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/dep")
public class DepartmentController {

    @Autowired
    DepartmentService service;

    @PostMapping("/dept/create")
    public ResponseEntity<Department> create(
            @RequestBody Department department) {
        return new ResponseEntity<>(service.create(department), HttpStatus.CREATED);
    }

    @GetMapping("/dept/{id}")
    public ResponseEntity<Department> findById(
            @PathVariable Long id) {
        return new ResponseEntity<>(service.read(id), HttpStatus.OK);
    }

    @GetMapping("/dept/depts")
    public ResponseEntity<Iterable<Department>> findAll() {
        return new ResponseEntity<>(service.readAll(), HttpStatus.OK);
    }

    @PutMapping("/dept/update/{id}")
    public ResponseEntity<Department> update(
            @PathVariable Long id,
            @RequestBody Department department) {
        return new ResponseEntity<>(service.updateManager(id, department), HttpStatus.OK);
    }

    @DeleteMapping("/dept/delete/{id}")
    public ResponseEntity<Department> delete(
            @PathVariable Long id) {
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }
}
