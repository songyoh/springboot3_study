package me.songyoh.springbootdeveloper.Controller;

import me.songyoh.springbootdeveloper.Repository.MemberRepository_00;
import me.songyoh.springbootdeveloper.entity.Member_00;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest // 테스트용 app 컨텍스트 생성
@AutoConfigureMockMvc // MockMvc 생성
class TestControllerTest_0000 {

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private MemberRepository_00 memberRepository;

    @BeforeEach // 테스트 실행 전 실행하는 메서드
    public void mockMvcSetUp(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @AfterEach // 테스트 실행 후 실행하는 메서드
    public void cleanUp(){
        memberRepository.deleteAll();
    }

    @DisplayName("getAllMembers : 아티클 조회에 성공한다.")
    @Test
    public void getAllMembers() throws Exception{
        //given 멤버 저장
        final String url = "/test";
        Member_00 savedMember = memberRepository.save(new Member_00(1L, "홍길동"));

        //when 멤버 리스트를 조회하는 API 호출
        final ResultActions result = mockMvc.perform(get(url)
                .accept(MediaType.APPLICATION_JSON));  // 변경된 부분

        //then 응답코드가 200 ok이고, 반환받은 값 중에 0번째 요소의 ID와 name이 저장된 값과 같은지 확인
        result
                .andExpect(status().isOk())
                // 응답의 0번째 값이 DB에서 저장한 값과 같은지 확인
                .andExpect(jsonPath("$[0].id").value(savedMember.getId()))
                .andExpect(jsonPath("$[0].name").value(savedMember.getName()));
    }
}