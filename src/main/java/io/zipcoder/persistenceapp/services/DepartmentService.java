package io.zipcoder.persistenceapp.services;

import io.zipcoder.persistenceapp.entities.Department;
import io.zipcoder.persistenceapp.exceptions.ResourceNotFoundException;
import io.zipcoder.persistenceapp.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository){
        this.departmentRepository = departmentRepository;
    }

    public Iterable<Department> getAllDepartments(){
        return departmentRepository.findAll();
    }

    public Department getDepartmentById(Long id){
        verifyDepartment(id);
        return departmentRepository.findOne(id);
    }

    public String getDepartmentName(Long id){
        verifyDepartment(id);
        return getDepartmentById(id).getDEPARTMENT_NAME();
    }

    public Department updateDepartmentManager(Department newData, Long ID){

        verifyDepartment(ID);

        Department existingData = departmentRepository.findOne(ID);
        existingData.setDEPARTMENT_MANAGER(newData.getDEPARTMENT_MANAGER());
        return departmentRepository.save(existingData);
    }

    public Department updateDepartmentName(Department newData, Long id){

        verifyDepartment(id);

        Department existingData = departmentRepository.findOne(id);
        existingData.setDEPARTMENT_NAME(newData.getDEPARTMENT_NAME());
        return departmentRepository.save(existingData);
    }

    private void verifyDepartment(Long departmentId){
        if (departmentRepository.exists(departmentId)){

        } else {
            throw new ResourceNotFoundException("Department not found!");
        }
    }

}
