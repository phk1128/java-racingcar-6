package racingcar.domain;

import java.util.Objects;
import racingcar.constant.ErrorMessage;

public class Car {

    private static final int MAXIMUM_NAME_RANGE = 5;

    private final String name;
    private int position;

    private Car(String name) {
        this.name = name;
    }

    public static Car create(String name) {
        validateNameRange(name);
        return new Car(name);
    }

    private static void validateNameRange(String name) {
        if (isWrongRange(name)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_CAR_NAMES.getMessage());
        }
    }

    private static boolean isWrongRange(String name) {
        return name.length() > MAXIMUM_NAME_RANGE;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move(int number) {
        if (number >= 4) {
            position++;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return Objects.equals(this.name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
