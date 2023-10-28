package racingcar.util

enum class Message(
    val message: String
) {
    NUMBER_OF_CARS_INPUT("자동차 대수는 몇 대인가요?"),
    NUMBER_OF_TRIALS_INPUT("시도할 횟수는 몇 회인가요?"),
    INPUT_EXCEPTION("정수를 입력하여 주세요."),
    RACE_RESULT_FIRST_LINE("실행 결과\n")
}
