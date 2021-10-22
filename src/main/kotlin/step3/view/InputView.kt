package step3.view

import step3.filter.ValueFilter

class InputView {

    fun inputNumberOfCars(): Int {
        println(NUMBER_OF_CARS)
        return ValueFilter.verify(readLine()!!)
    }

    fun inputNumberOfAttempts(): Int {
        println(NUMBER_OF_ATTEMPTS)
        return ValueFilter.verify(readLine()!!)
    }

    companion object {
        private const val NUMBER_OF_CARS = "자동차 대수는 몇대인가요?"
        private const val NUMBER_OF_ATTEMPTS = "시도할 횟수는 몇 회 인가요?"
    }
}
