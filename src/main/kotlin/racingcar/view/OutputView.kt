package racingcar.view

import racingcar.domain.Car

class OutputView {
    fun printResultGuide() {
        println(MESSAGE_RACE_RESULT)
    }

    fun printResult(cars: List<Car>) {
        cars.forEach { car -> printRound(car) }
        println()
    }

    private fun printRound(car: Car) {
        println(SYMBOL_FORWARD.repeat(car.position))
    }

    companion object {
        private const val MESSAGE_RACE_RESULT = "Race Results:"
        private const val SYMBOL_FORWARD = "-"
    }
}
