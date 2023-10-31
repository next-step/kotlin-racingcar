package racingcar.util

import racingcar.domain.NameValidation

enum class Message(
    val message: String
) {
    CAR_RACING_MOVING_SYMBOL("-"),
    NAME_OF_CARS_INPUT("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."),
    NUMBER_OF_TRIALS_INPUT("시도할 횟수는 몇 회인가요?"),
    INPUT_EXCEPTION("이름을 입력하여 주세요."),
    INPUT_NUMBER_EXCEPTION("정수를 입력하여 주세요."),
    RACE_RESULT_FIRST_LINE("실행 결과"),
    WINNER_LINE("가 최종 우승했습니다."),
    CAR_NAME_LENGTH_EXCEPTION("자동차의 이름은 ${NameValidation.NAME_MAX_LENGTH}글자까지 입력 가능합니다.")
}
