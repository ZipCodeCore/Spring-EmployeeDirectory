package io.zipcoder.persistenceapp.controllers;

import io.zipcoder.persistenceapp.entities.Department;
import io.zipcoder.persistenceapp.repositories.DepartmentRepository;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;


@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class DepartmentControllerTest {


    @Autowired
    private MockMvc mvc;

    @MockBean
    private DepartmentRepository repository;


    @Test
    public void testGetAllDepartments () throws Exception {
        List<Department> allDepts = new ArrayList<>();
        allDepts.add(new Department());
        allDepts.add(new Department());

        // given
        BDDMockito
            .given(repository.findAll())
            .willReturn(allDepts);

        // when
        this.mvc.perform( MockMvcRequestBuilders
                .get("/api/department/")
        ) .andExpect(MockMvcResultMatchers.status().isOk());


        this.mvc.perform(MockMvcRequestBuilders
        .get("/api/departments/")
        ) .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }

    @Test
    public void testGetDepartmentName() throws Exception{

    }
}