package racingcar.racing.printer

import racingcar.racing.car.Car
import racingcar.racing.view.View

interface CarPrinter {
    val view: View
    fun printString(car: Car): String
    fun print(car: Car) = view.print(printString((car)))
}
