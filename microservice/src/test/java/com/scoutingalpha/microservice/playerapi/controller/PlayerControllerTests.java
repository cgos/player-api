package com.scoutingalpha.microservice.playerapi.controller;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class PlayerControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @Test
    // https://www.baeldung.com/integration-testing-in-spring
    public void noParamPlayerShouldReturnDefaultPlayer() throws Exception {
        this.mockMvc.perform(get("/player/one")).andDo(print())
                .andExpect(status().isOk()).andExpect(jsonPath("$.fullName").value("Wayne"));
    }
}
