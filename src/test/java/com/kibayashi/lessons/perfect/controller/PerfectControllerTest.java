package com.kibayashi.lessons.perfect.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kibayashi.lessons.perfect.dto.PerfectResponseDto;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class PerfectControllerTest {
    protected MockMvc mvc;
    @Autowired
    private WebApplicationContext webApplicationContext;
    @Autowired
    private ObjectMapper mapper;

    @BeforeEach
    void init() {
        this.mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    @SneakyThrows
    void getPerfectResponse() {
        MvcResult mvcResult = mvc.perform(get(PerfectController.ROOT))
            .andDo(print())
            .andExpect(status().isOk())
            .andReturn();

        PerfectResponseDto perfectResponseDto = this.readJson(mvcResult, PerfectResponseDto.class);

        assertEquals(perfectResponseDto.getMessage(), PerfectController.RESPONSE_MESSAGE);
    }

    @SneakyThrows
    protected <T> T readJson(final MvcResult mvcResult, final Class<T> clazz) {
        return this.readJson(mvcResult.getResponse().getContentAsString(), clazz);
    }

    @SneakyThrows
    protected <T> T readJson(final String json, final Class<T> clazz) {
        return mapper.readValue(json, clazz);
    }

}
