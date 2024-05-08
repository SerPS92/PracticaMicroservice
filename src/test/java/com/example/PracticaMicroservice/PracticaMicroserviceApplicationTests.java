package com.example.PracticaMicroservice;

import org.aspectj.apache.bcel.ExceptionConstants;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PracticaMicroserviceApplicationTests {

    @Autowired
    MockMvc mockMvc;

    @Test
    @Order(3)
    void personaText() throws Exception {
        mockMvc.perform(get("/persona")).andDo(print());
    }

    @Test
    @Order(2)
    void deleteTest() throws Exception {
        mockMvc.perform(delete("/persona/2")).andDo(print());
    }

    @Test
    @Order(0)
    void addTest() throws Exception {
        mockMvc.perform(post("/persona").contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":null,\"nombre\":\"Florentino\",\"apellido\":\"Perez\",\"dni\":\"11221122\"}"))
                .andDo(print());
    }

    @Test
    @Order(1)
    void putTest() throws Exception {
        mockMvc.perform(put("/persona").contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":6,\"nombre\":\"Floren\",\"apellido\":\"Fernandez\",\"dni\":\"55521122\"}")
        ).andDo(print());
    }

}
