package com.example.codefellowship;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class CodefellowshipApplicationTests {

	@Autowired
	MockMvc mockMvc;
	@Test
	void contextLoads() {
	}
	@Test void homePageTest() throws Exception {

			mockMvc.perform(get("/"))
					.andExpect(content().string(containsString("<P> Codefellowship is about people like you! All are welcome, " +
							"and all are appreciated.</P>")))
					.andExpect(content().string(containsString("<p>Interested in signing up? click the link below! </p>")))
					.andExpect(status().isOk());
		}
	@Test void signupPageTest() throws Exception {

		mockMvc.perform(get("/signup"))
				.andExpect(content().string(containsString("<h1>Welcome New User</h1>")))
				.andExpect(content().string(containsString("<form action=\"/appUser\" method=\"post\">")))
				.andExpect(status().isOk());
	}

	@Test void loginPageTest() throws Exception {

		mockMvc.perform(get("/login"))
				.andExpect(content().string(containsString("<h1>Login</h1>")))
				.andExpect(content().string(containsString("<form action=\"/login\" method=\"post\">")))
				.andExpect(status().isOk());
	}


}
