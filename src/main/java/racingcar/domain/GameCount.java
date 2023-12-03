package racingcar.domain;

import static racingcar.util.ErrorMessage.*;

public class GameCount {

    private final int count;

    private GameCount(int count) {
        this.count = count;
    }

    public static GameCount create(String inputCount) {
        int count = covertStringToInt(inputCount);
        return new GameCount(count);
    }

    public int getCount() {
        return count;
    }

    private static int covertStringToInt(String inputCount) {
        try {
            return Integer.parseInt(inputCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_INPUT.getMessage());
        }
    }
}
