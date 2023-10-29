package racingcar.presentation

class InputManager {
    fun inputNumberOfCar(): Int {
        println(INPUT_NUMBER_OF_CARS_MESSAGE)
        return readln().toInt()
    }

    fun inputNumberOfCount(): Int {
        println(INPUT_NUMBER_OF_COUNT_MESSAGE)
        return readln().toInt()
    }

    companion object {
        const val INPUT_NUMBER_OF_CARS_MESSAGE = "자동차 대수는 몇 대인가요?"
        const val INPUT_NUMBER_OF_COUNT_MESSAGE = "시도할 횟수는 몇 회인가요?"
    }
}
