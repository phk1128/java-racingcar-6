package racingcar.constant;

public enum ErrorMessage {

    INVALID_CAR_NAMES("자동차 이름은 5글자 이하여야합니다."),
    DUPLICATE_CAR_NAMES("자동차 이름은 중복될 수 없습니다."),
    INVALID_ATTEMPT("회수는 0이상 숫자만 가능합니다.")
    ;

    private static final String PREFIX = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX + message;
    }
}
