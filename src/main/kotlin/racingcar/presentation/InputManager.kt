package racingcar.presentation

import racingcar.domain.CarNames

class InputManager {
    fun inputNumberOfCar(): Int {
        println(INPUT_NUMBER_OF_CARS_MESSAGE)
        return readln().toInt()
    }

    fun inputCarNames(): CarNames {
        println(INPUT_NAME_OF_CARS_MESSAGE)
        val value: String = readln()
        return CarNames(value.split(","))
    }

    fun inputNumberOfCount(): Int {
        println(INPUT_NUMBER_OF_COUNT_MESSAGE)
        return readln().toInt()
    }

    companion object {
        const val INPUT_NUMBER_OF_CARS_MESSAGE = "자동차 대수는 몇 대인가요?"
        const val INPUT_NAME_OF_CARS_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
        const val INPUT_NUMBER_OF_COUNT_MESSAGE = "시도할 횟수는 몇 회인가요?"
        const val NAME_VALID_ERROR_MESSAGE = "입력값이 공백이거나 Null일 수 없습니다"
    }
}
