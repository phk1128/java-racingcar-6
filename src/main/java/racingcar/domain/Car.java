package racingcar.domain;

import static racingcar.util.ErrorMessage.INVALID_INPUT;

import java.util.stream.Stream;
import racingcar.util.RandomNumberGenerator;

public class Car {

    private static final int MAX_NAME_LENGTH = 5;
    private static final int FORWARD_CONDITION = 4;
    private final String name;
    private final int position;

    private Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public static Car create(String inputCar, GameCount gameCount, RandomNumberGenerator randomNumberGenerator) {
        validateCarName(inputCar);
        int count = gameCount.getCount();
        int position = calculatePosition(count, randomNumberGenerator);
        return new Car(inputCar, position);
    }

    private static void validateCarName(String inputCar) {
        if (isExceedsNameLength(inputCar)) {
            throw new IllegalArgumentException(INVALID_INPUT.getMessage());
        }
    }

    private static boolean isExceedsNameLength(String inputCar) {
        return inputCar.length() > MAX_NAME_LENGTH;
    }

    private static int calculatePosition(int count, RandomNumberGenerator randomNumberGenerator) {
        return (int) Stream.iterate(0, i -> i + 1).limit(count)
                .filter(i -> randomNumberGenerator.generate() >= FORWARD_CONDITION)
                .count() - count;
    }

    public int calculateForward(int forward) {
        return position + forward;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
