package coupleApp.coupleApp.controller;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;

@WebMvcTest(CoupleController.class)
//@AutoConfigureWebMvc // 이 어노테이션을 통해 MockMvc를 Builder 없이 주입받을 수 있음
public class CoupleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    // ProdcutController에서 잡고 있는 Bean 객체에 대해 Mock 형태의 객체 생성
//    @MockBean
//    ProdcutServiceImpl productService;

    @Test
    @DisplayName("커플 정보 가져오기 테스트")
    void getCoupleTest() throws  Exception {

        // given : Mock 객체가 특정 상황에서 해야하는 행위를 정의하는 메소드
//        given(productService.getProduct)
    }

}
