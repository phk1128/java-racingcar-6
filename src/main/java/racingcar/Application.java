package racingcar;

import racingcar.controller.RacingcarController;
import racingcar.service.RacingcarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        RacingcarController racingcarController = new RacingcarController(
                new InputView(),
                new OutputView(),
                new RacingcarService()
        );

        racingcarController.run();
    }
}
