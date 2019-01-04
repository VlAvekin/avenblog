package com.vladavekin.web;

import com.vladavekin.web.controller.BlogController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.xpath;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@WithUserDetails("3")
@TestPropertySource("/application-test.properties")
@Sql(value = {"/create-user-before.sql" , "/articles-list-before.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = {"/articles-list-after.sql", "/create-user-after.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class BlogControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired

    private BlogController controller;

    @Test
    public void blogPageTest() throws Exception {
        assertThat(controller).isNotNull();
        this.mockMvc.perform(get("/blog"))
                .andDo(print())
                .andExpect(authenticated())
                .andExpect(xpath("//*[@id=\"navbarSupportedContent\"]/div").string("3"));
    }

    @Test
    public void messageListTest() throws Exception {
        this.mockMvc.perform(get("/blog"))
                .andDo(print())
                .andExpect(authenticated())
                .andExpect(xpath("//div[@id='article-list']/div").nodeCount(4));
    }

    @Test
    public void filterMessageTest() throws Exception {
        this.mockMvc.perform(get("/blog"))
                .andDo(print())
                .andExpect(authenticated());
    }
}
