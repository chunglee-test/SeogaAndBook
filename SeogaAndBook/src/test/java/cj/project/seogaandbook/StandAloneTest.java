package cj.project.seogaandbook;

// 이부분 추가하셔야 합니다.
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import cj.project.seogaandbook.controller.HomeController;

public class StandAloneTest {

	private MockMvc mockMvc;

	// 테스트 메소드 실행전 셋업 메소드입니다.
	@Before
	public void setup(){
		// 이곳에서 HomeController를 MockMvc 객체로 만듭니다.
		this.mockMvc = MockMvcBuilders.standaloneSetup(new HomeController()).build();
	}

	
	public void test() throws Exception{
		// HomeController의 "/" 매핑으로 정의합니다.
		this.mockMvc.perform(get("/"))
		// 처리 내용을 출력합니다.
		.andDo(print())
		// 상태값은 OK가 나와야 합니다.
		.andExpect(status().isOk())
		// "serverTime"이라는 attribute가 존재해야 합니다.
		.andExpect(model().attributeExists("serverTime"));
	}
	
	@Test
	public void test1() throws Exception {
		MvcResult result = 
				this.mockMvc.perform(get("/test1"))
				.andDo(print())
				.andExpect(status().isOk())
				.andReturn();
		
		System.out.println(result.getModelAndView().getModel().toString());
	}
}