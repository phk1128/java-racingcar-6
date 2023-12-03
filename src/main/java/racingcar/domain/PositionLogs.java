package racingcar.domain;

import java.util.List;

public class PositionLogs {

    private final List<PositionLog> positionLogs;

    private PositionLogs(List<PositionLog> positionLogs) {
        this.positionLogs = positionLogs;
    }

    public static PositionLogs create(List<PositionLog> positionLogs) {
        return new PositionLogs(positionLogs);
    }

    public List<PositionLog> getPositionLogs() {
        return positionLogs;
    }
}
