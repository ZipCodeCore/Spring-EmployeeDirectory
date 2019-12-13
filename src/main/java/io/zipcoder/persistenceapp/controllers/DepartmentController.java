package io.zipcoder.persistenceapp.controllers;

import io.zipcoder.persistenceapp.entities.Department;
import io.zipcoder.persistenceapp.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/department/")
public class DepartmentController {

    DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService){
        this.departmentService = departmentService;
    }

    @GetMapping
    public ResponseEntity<Iterable<Department>> getAllDepartments(){
        return new ResponseEntity<>(departmentService.getAllDepartments(), HttpStatus.OK);
    }

    @GetMapping("{id}/name")
    public String getDepartmentName (@PathVariable Long id){
        return departmentService.getDepartmentName(id);
    }

    @GetMapping("{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable Long id){
        return new ResponseEntity<Department>(departmentService.getDepartmentById(id),HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Department> updateDepartmentManager(@RequestBody Department newData, @PathVariable Long id){
        return new ResponseEntity<Department>(departmentService.updateDepartmentManager(newData, id),HttpStatus.OK);
    }




    //   TODO
    // create a department
    // update department with a new manager
    // change name of a department

}
