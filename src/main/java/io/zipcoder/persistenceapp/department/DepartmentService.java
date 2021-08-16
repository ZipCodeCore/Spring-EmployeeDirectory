package io.zipcoder.persistenceapp.department;


import io.zipcoder.persistenceapp.employee.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepo repo;

    public Department create(Department dep) {
        return repo.save(dep);
    }

    public Department read(Long id) {
        return repo.findOne(id);
    }

    public List<Department> readAll() {
        Iterable<Department> departmentIterable = repo.findAll();
        List<Department> depList = new ArrayList<>();
        departmentIterable.forEach(depList::add);
        return depList;
    }

    // could integrate passing an Employee through name to update manager
    public Department updateManager(Long id, String manager) {
        Department inDb = read(id);
        inDb.setDepManager(manager);
        inDb = repo.save(inDb);
        return inDb;
    }

    public Department delete(Long id) {
        Department dep = read(id);
        repo.delete(dep);
        return dep;
    }

    public Department delete(Department dep) {
        return delete(dep.getDepId());
    }

    public List<Department> delete(List<Department> listToDelete) {
        listToDelete.forEach(repo::delete);
        return listToDelete;
    }
}
