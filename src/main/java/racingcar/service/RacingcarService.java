package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.CarGroup;
import racingcar.util.NumberGenerator;
import racingcar.util.RandomNumberGenerator;

public class RacingcarService {

    public CarGroup createCarGroup(List<String> inputCarNames) {
        List<Car> cars = new ArrayList<>();
        NumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        for (String inputCarName : inputCarNames) {
            cars.add(Car.create(inputCarName));
        }
        return CarGroup.create(cars,randomNumberGenerator);
    }

    public void moveCars(CarGroup carGroup) {
        carGroup.move();
    }

    public List<Car> getCars(CarGroup carGroup) {
        return carGroup.getCars();
    }

    public List<Car> getWinners(CarGroup carGroup) {
        return carGroup.getWinner();
    }


}
