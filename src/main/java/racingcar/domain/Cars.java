package racingcar.domain;

import static racingcar.util.ErrorMessage.*;

import java.util.List;


public class Cars {

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars create(List<Car> cars) {
        validateDuplicate(cars);
        return new Cars(cars);
    }

    public List<Car> getCars() {
        return cars;
    }

    private static void validateDuplicate(List<Car> cars) {
        if (isDuplicate(cars)) {
            throw new IllegalArgumentException(INVALID_INPUT.getMessage());
        }
    }

    private static boolean isDuplicate(List<Car> cars) {
        return cars.stream()
                .distinct()
                .count() != cars.size();
    }

    public List<String> findWinner() {
        int maxPosition = calculateMaxPosition();
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .toList();
    }

    private int calculateMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }


}
