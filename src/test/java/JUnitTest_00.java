import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class JUnitTest_00 {
    @DisplayName("1+2는 3이다")
    @Test
    public void junitTest(){
        int a = 1;
        int b = 2;
        int sum = 3;

        Assertions.assertEquals(a + b, sum); // 값이 같은지 확인
    }

//    @DisplayName("1+3 = 4")
//    @Test
//    public void junitFailedTest(){
//        int a = 1;
//        int b = 3;
//        int sum = 3;
//
//        Assertions.assertEquals(a+b, sum);
//    }
}
