package racingcar.controller;

import java.util.List;
import racingcar.domain.Cars;
import racingcar.domain.GameCount;
import racingcar.service.RacingcarService;
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
        String inputCars = requestCars();
        String inputGameCount = requestGameCount();
        GameCount gameCount = racingcarService.createGameCount(inputGameCount);
        Cars cars = racingcarService.createCars(inputCars, gameCount);
        String gameResult = racingcarService.createResult(cars, gameCount);
        List<String> winners = racingcarService.getWinner(cars);

        responseGameResult(gameResult);
        responseWinners(winners);
    }


    private String requestGameCount() {
        outputView.printAskGameCount();
        return inputView.readInput();
    }

    private String requestCars() {
        outputView.printAskCars();
        return inputView.readInput();
    }

    private void responseWinners(List<String> winners) {
        outputView.printWinners(winners);
    }

    private void responseGameResult(String gameResult) {
        outputView.printGameResult(gameResult);
    }




}
