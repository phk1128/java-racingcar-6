//package racingcar.domain;
//
//import static org.assertj.core.api.Assertions.assertThatThrownBy;
//import static org.junit.jupiter.api.Assertions.*;
//
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.ValueSource;
//
//class CarsTest {
//
//    @DisplayName("잘못된 입력으로 예외가 발생한다.")
//    @ValueSource(strings = "123456, 12")
//    @ParameterizedTest
//    void validateCars(String input) throws Exception {
//        //given
//        //when
//        //then
//        assertThatThrownBy(() -> Cars.create(input))
//                .isInstanceOf(IllegalArgumentException.class)
//                .hasMessageContaining("[ERROR]");
//    }
//
//}