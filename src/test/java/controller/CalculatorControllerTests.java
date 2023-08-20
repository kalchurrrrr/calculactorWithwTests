package controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(CalculatorController.class)
@AutoConfigureMockMvc
public class CalculatorControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testWelcome() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/calculator"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Добро пожаловать в калькулятор"));
    }

    @Test
    public void testPlus() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/calculator/plus?num1=5&num2=5"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("5 + 5 = 10"));
    }

    @Test
    public void testMinus() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/calculator/minus?num1=5&num2=5"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("5 - 5 = 0"));
    }

    @Test
    public void testMultiply() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/calculator/multiply?num1=5&num2=5"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("5 * 5 = 25"));
    }

    @Test
    public void testDivide() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/calculator/divide?num1=5&num2=5"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("5 / 5 = 1"));
    }
}
