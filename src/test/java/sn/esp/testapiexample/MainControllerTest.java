package sn.esp.testapiexample;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


import sn.esp.testapiexample.Controller.MainController;

@RunWith(SpringJUnit4ClassRunner.class)
public class MainControllerTest {


    private MockMvc mockMvc;

    @InjectMocks
    private MainController mainController;

    @Before
    public void setup() throws Exception{
        mockMvc = MockMvcBuilders.standaloneSetup(mainController)
            .build();
    }

    @Test
    public void testHelloWorld() throws Exception{
        mockMvc.perform(
            MockMvcRequestBuilders.get("/api/home")
        )
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().string("Hello"));
    }

    @Test
    public void testHelloWorldStatus() throws Exception{
        mockMvc.perform(
            MockMvcRequestBuilders.get("/api/home")
        )
            .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testJson() throws Exception{
        mockMvc.perform(
            MockMvcRequestBuilders.get("/api/home/json")
        )
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(jsonPath("$.title", Matchers.is("TestJson")))
            .andExpect(jsonPath("$.value", Matchers.is("Hello guys")));
    }
    
}
