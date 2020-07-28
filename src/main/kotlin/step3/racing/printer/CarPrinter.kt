package step3.racing.printer

import step3.racing.car.Car
import step3.racing.view.View

interface CarPrinter {
    val view: View
    fun printString(car: Car): String
    fun print(car: Car) = view.print(printString((car)))
}
