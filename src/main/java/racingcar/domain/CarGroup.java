package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import racingcar.constant.ErrorMessage;
import racingcar.util.NumberGenerator;

public class CarGroup {

    private final List<Car> cars;
    private final NumberGenerator numberGenerator;

    private CarGroup(List<Car> cars, NumberGenerator numberGenerator) {
        this.cars = cars;
        this.numberGenerator = numberGenerator;
    }

    public static CarGroup create(List<Car> cars, NumberGenerator numberGenerator) {
        validateDuplicate(cars);
        return new CarGroup(cars, numberGenerator);
    }

    public void move() {
        for (Car car : cars) {
            int randomNumber = numberGenerator.generate();
            car.move(randomNumber);
        }
    }

    public List<Car> getWinner() {
        int maxPosition = getMaxPosition();
        return cars.stream()
                .filter(car -> Objects.equals(car.getPosition(), maxPosition))
                .toList();
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    private static void validateDuplicate(List<Car> cars) {
        if (isDuplicate(cars)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_CAR_NAMES.getMessage());
        }
    }

    private static boolean isDuplicate(List<Car> cars) {
        return cars.stream()
                .distinct()
                .count() != cars.size();
    }

    public List<Car> getCars() {
        return cars;
    }
}
