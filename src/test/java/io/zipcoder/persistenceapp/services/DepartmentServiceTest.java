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

@SpringBootTest
@RunWith(SpringRunner.class)
public class DepartmentServiceTest {

    @MockBean
    private DepartmentRepository repository;

    @Autowired
    private DepartmentService service;


    @Test
    public void getDepartmentById() {
    }

    @Test
    public void getDepartmentName() {
        Long givenId = 1L;
        String expected = "MARKETING";
        Department departmentTest = new Department();
        departmentTest.setDEPARTMENT_NAME(expected);
        departmentTest.setDEPARTMENT_ID(givenId);

        BDDMockito
                .given(repository.save(departmentTest))
                .willReturn(departmentTest);

        BDDMockito
                .given(repository.findOne(givenId))
                .willReturn(departmentTest);

        BDDMockito
                .given(repository.exists(givenId))
                .willReturn(true);

        String response = service.getDepartmentName(givenId);

        Assert.assertEquals(expected,response);
    }
}