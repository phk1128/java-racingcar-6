package racingcar.view;

import java.util.List;

public class OutputView {

    public void printAskCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printAskAttempt() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void printResult(String carName, int position) {
        System.out.println(carName + " : " + "-".repeat(position));
    }

    public void printBreakLine() {
        System.out.println();
    }

    public void printWinners(List<String> winners) {
        String message = String.join(", ", winners);
        System.out.println("최종 우승자 : " + message);
    }

}
