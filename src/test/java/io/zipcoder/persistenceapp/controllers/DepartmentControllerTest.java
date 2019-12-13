package io.zipcoder.persistenceapp.controllers;

import io.zipcoder.persistenceapp.entities.Department;
import io.zipcoder.persistenceapp.repositories.DepartmentRepository;
import io.zipcoder.persistenceapp.services.DepartmentService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Optional;


@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class DepartmentControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private DepartmentRepository repository;

    @Autowired
    private DepartmentService service;

    @Test
    public void testGetAllDepartments () throws Exception {

    }

    @Test
    public void testGetDepartmentName() throws Exception{
//
//        this.mvc.perform(MockMvcRequestBuilders
//        .get("/1/name")
//        .content(expected)
//        .accept(MediaType.ALL)
//        .contentType(MediaType.ALL_VALUE))
//                .andExpect(MockMvcResultMatchers.content().string(expected));


    }
}