package io.zipcoder.persistenceapp.services;

import io.zipcoder.persistenceapp.entities.Department;
import io.zipcoder.persistenceapp.repositories.DepartmentRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DepartmentServiceTest {

    @MockBean
    private DepartmentRepository repository;

    @Autowired
    private DepartmentService service;


    @Test
    public void getDepartmentById() {
        Long givenId = 1L;
        Department departmentTest = new Department();
        departmentTest.setDEPARTMENT_NAME("Marketing");
        departmentTest.setDEPARTMENT_ID(givenId);

        BDDMockito
                .given(repository.findOne(givenId))
                .willReturn(departmentTest);

        BDDMockito
                .given(repository.exists(givenId))
                .willReturn(true);

        Department response = service.getDepartmentById(givenId);

        Assert.assertEquals(departmentTest,response);
    }

    @Test
    public void getDepartmentName() {
        Long givenId = 1L;
        String expected = "MARKETING";
        Department departmentTest = new Department();
        departmentTest.setDEPARTMENT_NAME(expected);
        departmentTest.setDEPARTMENT_ID(givenId);


        BDDMockito
                .given(repository.findOne(givenId))
                .willReturn(departmentTest);

        BDDMockito
                .given(repository.exists(givenId))
                .willReturn(true);

        String response = service.getDepartmentName(givenId);

        Assert.assertEquals(expected,response);
    }

    @Test
    public void testGetAllDepartments(){
        Department departmentTest = new Department();
        departmentTest.setDEPARTMENT_NAME("Test1");
        departmentTest.setDEPARTMENT_ID(1L);
        Department departmentTest2 = new Department();
        departmentTest2.setDEPARTMENT_NAME("Test1");
        departmentTest2.setDEPARTMENT_ID(2L);

        List<Department> allDepartments = new ArrayList<>();
        allDepartments.add(departmentTest);
        allDepartments.add(departmentTest2);

        BDDMockito
                .given(repository.findAll())
                .willReturn(allDepartments);

        Integer expected = 2;
        Integer actual = allDepartments.size();

        Assert.assertEquals(expected,actual);
    }
}