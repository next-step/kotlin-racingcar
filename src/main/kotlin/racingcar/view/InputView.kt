package racingcar.view

import racingcar.validator.InputValidator

object InputView {
    private const val INPUT_CAR_LIST_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
    private const val INPUT_COUNT_MESSAGE = "시도할 횟수는 몇 회인가요?"
    private const val SEPARATOR = ","

    fun inputCarList(): List<String> {
        println(INPUT_CAR_LIST_MESSAGE)
        return readln().split(SEPARATOR)
    }

    fun inputGameCount(): Int {
        println(INPUT_COUNT_MESSAGE)
        return InputValidator.validateInput(readln())
    }
}
