package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import racingcar.constant.ErrorMessage;
import racingcar.domain.Car;
import racingcar.domain.CarGroup;
import racingcar.service.RacingcarService;
import racingcar.util.LoopTemplate;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingcarController {

    private final InputView inputView;
    private final OutputView outputView;
    private final RacingcarService racingcarService;

    public RacingcarController(
            InputView inputView,
            OutputView outputView,
            RacingcarService racingcarService
    ) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.racingcarService = racingcarService;
    }

    public void run() {
        CarGroup carGroup = requestCarGroup();
        int attempt = requestAttempt();
        moveCars(carGroup,attempt);
        List<Car> winners = racingcarService.getWinners(carGroup);
        responseWinners(winners);
    }

    private void responseWinners(List<Car> winners) {
        List<String> winnerList = winners.stream()
                .map(Car::getName)
                .toList();
        outputView.printWinners(winnerList);
    }

    private CarGroup requestCarGroup() {
        return LoopTemplate.tryCatchLoop(() -> {
            outputView.printAskCarNames();
            String input = inputView.readInput();
            input = input.replace(" ","");
            List<String> carNames = convertStringToList(input);
            return racingcarService.createCarGroup(carNames);
        });

    }

    private List<String> convertStringToList(String input) {
        return Arrays.stream(input.split(","))
                .toList();
    }

    private void moveCars(CarGroup carGroup, int attempt) {
        if (attempt == 0) {
            return;
        }
        attempt--;
        racingcarService.moveCars(carGroup);
        List<Car> cars = racingcarService.getCars(carGroup);
        responseResult(cars);
    }

    private void responseResult(List<Car> cars) {
        for (Car car : cars) {
            String name = car.getName();
            int position = car.getPosition();
            outputView.printResult(name,position);
        }
        outputView.printBreakLine();
    }

    private int requestAttempt() {
        return LoopTemplate.tryCatchLoop(() ->{
            outputView.printAskAttempt();
            String input = inputView.readInput();
            int attempt = convertStringToInt(input);
            validateAttempt(attempt);
            return attempt;
        });
    }

    private int convertStringToInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_ATTEMPT.getMessage());
        }
    }

    private void validateAttempt(int attempt) {
        if (attempt < 0 ) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_ATTEMPT.getMessage());
        }
    }
}
