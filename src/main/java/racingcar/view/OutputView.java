package racingcar.view;

import java.util.List;

public class OutputView {

    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final String ASK_CARS = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ASK_GAME_COUNT = "시도할 회수는 몇회인가요?";
    private static final String RESULT = LINE_SEPARATOR + "실행 결과";
    private static final String WINNER = "최종 우승자 : %s";

    public void printAskCars() {
        System.out.println(ASK_CARS);
    }

    public void printAskGameCount() {
        System.out.println(ASK_GAME_COUNT);
    }

    public void printGameResult(String gameResult) {
        System.out.println(RESULT);
        System.out.print(gameResult);
    }

    public void printWinners(List<String> winners) {
        String message = String.format(WINNER, String.join(", ", winners));
        System.out.print(message);
    }
}
