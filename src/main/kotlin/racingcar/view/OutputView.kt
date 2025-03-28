package racingcar.view

import racingcar.domain.car.Car
import racingcar.domain.car.Cars

class OutputView {
    fun printResultGuide() {
        println(MESSAGE_RACE_RESULT)
    }

    fun printResult(cars: Cars) {
        cars.cars.forEach { car -> printRound(car) }
        println()
    }

    private fun printRound(car: Car) {
        print("${car.name.value}: ")
        println(SYMBOL_FORWARD.repeat(car.position))
    }

    fun printWinners(cars: List<Car>) {
        val names = cars.map { it.name.value }
        println(names.joinToString(SEPARATOR))
    }

    companion object {
        private const val MESSAGE_RACE_RESULT = "Race Results:"
        private const val SYMBOL_FORWARD = "-"
        private const val SEPARATOR = ", "
    }
}
