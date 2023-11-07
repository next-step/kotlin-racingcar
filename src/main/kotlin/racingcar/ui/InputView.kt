package racingcar.ui

private const val INPUT_RACING_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
private const val INPUT_COUNT_OF_RACING_MESSAGE = "시도할 횟수는 몇 회인가요?"
private const val RACING_CAR_NAME_DELIMITER = ","

object InputView {
    fun inputNames(): List<String> {
        println(INPUT_RACING_CAR_NAME_MESSAGE)
        return readln().split(RACING_CAR_NAME_DELIMITER)
    }

    fun inputCount(): Int {
        println(INPUT_COUNT_OF_RACING_MESSAGE)
        return readln().toInt()
    }
}
