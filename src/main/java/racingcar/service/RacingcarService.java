package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.GameCount;
import racingcar.domain.PositionLog;
import racingcar.domain.PositionLogs;
import racingcar.util.RandomNumberGenerator;

public class RacingcarService {

    public GameCount createGameCount(String inputCount) {
        return GameCount.create(inputCount);
    }

    public Cars createCars(String inputCars, GameCount gameCount) {
        List<Car> cars = new ArrayList<>();
        String[] splitInputCars = inputCars.split(",");
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        for (String inputCar : splitInputCars) {
            Car car = Car.create(inputCar, gameCount, randomNumberGenerator);
            cars.add(car);
        }
        return Cars.create(cars);
    }

    public String createResult(Cars cars, GameCount gameCount) {
        int count = gameCount.getCount();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= count; i++) {
            makeResult(cars, i, sb);
        }
        return sb.toString();
    }

    private PositionLogs createPositionLogs(Cars cars, int forward) {
        List<PositionLog> positionLogs = new ArrayList<>();
        for (Car car : cars.getCars()) {
            PositionLog positionLog = PositionLog.create(car, forward);
            positionLogs.add(positionLog);
        }
        return PositionLogs.create(positionLogs);
    }

    private void makeResult(Cars cars, int forward, StringBuilder sb) {
        PositionLogs positionLogs = createPositionLogs(cars, forward);
        for (PositionLog positionLog :positionLogs.getPositionLogs()) {
            sb.append(positionLog.getCarName());
            sb.append(" : ");
            sb.append("-".repeat(positionLog.getLog()));
            sb.append(System.lineSeparator());
        }
        sb.append(System.lineSeparator());
    }

    public List<String> getWinner(Cars cars) {
        return cars.findWinner();
    }
}
