package racingcar.view

import racingcar.domain.Cars

private const val CONSOLE_CAR_POSITION_EXPRESSION = "-"

class ConsoleOutput : OutputView {
    override fun printCarPositions(cars: Cars) {
        cars.forEach { car -> println(car.position.value.toStringForPrint()) }
    }
}

private fun Int.toStringForPrint(): String {
    return CONSOLE_CAR_POSITION_EXPRESSION.repeat(this)
}
