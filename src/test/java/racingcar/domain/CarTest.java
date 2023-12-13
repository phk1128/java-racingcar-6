package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @DisplayName("전진 테스트")
    @Test
    void moveTest() throws Exception {
        //given
        String name = "형균";
        //when
        Car car = Car.create(name);
        //then
        car.move(4);
        System.out.println(car.getPosition());
    }

}