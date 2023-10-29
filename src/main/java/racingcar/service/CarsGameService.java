package racingcar.service;

import java.util.Map;
import java.util.Set;
import racingcar.domain.Cars;
import racingcar.domain.CarsGameCount;
import racingcar.domain.CarsGameLogs;
import racingcar.domain.CarsPosition;

public class CarsGameService {

    public Map<String,String> getUpdatedLogs(CarsPosition carsPosition, CarsGameLogs carsGameLogs) {
        updatePositionAndLogs(carsPosition, carsGameLogs);
        return carsGameLogs.getLogs();
    }

    private void updatePositionAndLogs(CarsPosition carsPosition, CarsGameLogs carsGameLogs) {
        Set<String> cars = carsPosition.getPosition().keySet();
        for(String car:cars) {
            carsPosition.update(car,1);
            int position = carsPosition.getPosition().get(car);
            carsGameLogs.update(car,position);
        }
    }

    public Cars generateCars(String carsInput) {
        return new Cars(carsInput);
    }

    public CarsGameCount generateCarsGameCount(String countInput) {
        return new CarsGameCount(countInput);
    }

    public CarsPosition generateCarsPosition(Map<String, Integer> carsMap, int carsGameCount) {
        return new CarsPosition(carsMap,carsGameCount);
    }

    public CarsGameLogs generateCarsGameLogs(Map<String, Integer> carsMap) {
        return new CarsGameLogs(carsMap);
    }
}
