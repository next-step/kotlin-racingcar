package racingcar.view

import racingcar.validator.InputValidator

object InputView {
    private const val INPUT_COUNT_MESSAGE = "자동차 대수는 몇 대인가요?"
    private const val INPUT_CAR_MESSAGE = "시도할 횟수는 몇 회인가요?"

    fun countOfCars(): Int {
        println(INPUT_COUNT_MESSAGE)
        return InputValidator.validateInput(readln())
    }

    fun countOfGames(): Int {
        println(INPUT_CAR_MESSAGE)
        return InputValidator.validateInput(readln())
    }
}
