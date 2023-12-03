package racingcar.domain;

public class PositionLog {

    private final String carName;
    private final int log;

    private PositionLog(String carName, int log) {
        this.carName = carName;
        this.log = log;
    }

    public static PositionLog create(Car car, int forward) {
        return new PositionLog(car.getName(), checkForward(car, forward));
    }

    private static int checkForward(Car car, int forward) {
        int log = 0;
        int position = car.calculateForward(forward);
        if (position > 0) {
            log += position;
        }
        return log;
    }

    public String getCarName() {
        return carName;
    }

    public int getLog() {
        return log;
    }
}
