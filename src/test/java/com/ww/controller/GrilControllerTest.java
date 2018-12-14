package com.ww.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.Assert.*;

/**
 * @author WangWei
 * @Title: GrilControllerTest
 * @ProjectName gril
 * @Description: TODO
 * @date 2018/10/9 16:07
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class GrilControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void grilList() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/gril/grils")).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("abc" ));
    }
}