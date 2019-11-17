package com.fandou.springboot.devtools;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultHandler;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fandou.springboot.devtools.model.Cat;
import com.fandou.springboot.devtools.service.IndexService;
import com.fasterxml.jackson.databind.ObjectMapper;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class SpringbootDevtoolsApplicationTests {
	private Logger logger = LogManager.getLogger(SpringbootDevtoolsApplicationTests.class);

	//@Autowired
	IndexService indexService;

	//@Autowired
	WebApplicationContext wac;

	MockMvc mockMvc;
	
	//@Before
	public void before() {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	//@Test
	public void test1() throws Exception {
		MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders.get("/cat");
		RequestBuilder requestBuilder = mockHttpServletRequestBuilder.contentType(MediaType.APPLICATION_FORM_URLENCODED)
				.param("name", "成尚谦");
		ResultMatcher resultMatcher = MockMvcResultMatchers.status().isOk();
		ResultHandler resultHandler = MockMvcResultHandlers.print();
		MvcResult mvcResult = mockMvc.perform(requestBuilder).andExpect(resultMatcher).andDo(resultHandler).andReturn();
		String result = mvcResult.getResponse().getContentAsString();
		logger.debug("test1 => " + result);
	}
	
	//@Test
	public void test2() throws Exception{
		ObjectMapper om = new ObjectMapper();
		Cat c = new Cat();
		c.setId(1);
		c.setName("C95");
		c.setColor("Blue");
		String catJsonString = om.writeValueAsString(c);
		
		MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders.post("/cats");
		RequestBuilder requestBuilder = mockHttpServletRequestBuilder.contentType(MediaType.APPLICATION_JSON).content(catJsonString);
		ResultMatcher resultMatcher = MockMvcResultMatchers.status().isOk();
		ResultHandler resultHandler = MockMvcResultHandlers.print();
		MvcResult mvcResult = mockMvc.perform(requestBuilder).andExpect(resultMatcher).andDo(resultHandler).andReturn();
		String result = mvcResult.getResponse().getContentAsString();
		logger.debug("test2 => " + result);
		
	}	

	//@Test
	public void contextLoads() {
		String sth = "Jerry";
		String hi = indexService.say(sth);
		Assert.assertThat(hi, Matchers.is("Hello," + sth));
		logger.debug("test3 => OK");
	}
}
