package com.oz.weather.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.oz.weather.test.InitTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@AutoConfigureMockMvc
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WeatherControllerTests extends InitTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void cityWeatherOk() throws Exception {
    this.mockMvc.perform(get("/weather/3996063")).andDo(print()).andExpect(status().isOk())
        .andExpect(jsonPath("$.cityName").value("Mexico"));
  }

  @Test
  public void cityWeatherNotFound() throws Exception {
    this.mockMvc.perform(get("/weather/123456789")).andDo(print()).andExpect(status().isNotFound())
        .andExpect(jsonPath("$.code").value(HttpStatus.NOT_FOUND.value()));
  }

  @Test
  public void cityWeatherBadRequest() throws Exception {
    this.mockMvc.perform(get("/weather/helloworld")).andDo(print()).andExpect(status().isBadRequest())
        .andExpect(jsonPath("$.code").value(HttpStatus.BAD_REQUEST.value()));
  }

  @Test
  public void cityWeatherMethodNotAllowed() throws Exception {
    this.mockMvc.perform(post("/weather/3996063")).andDo(print()).andExpect(status().isMethodNotAllowed());
  }
}
