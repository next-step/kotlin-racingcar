package step3.racing.printer

import step3.racing.car.Car
import step3.racing.view.View

class CarPrinterImpl(override val view: View) : CarPrinter {
    override fun printString(car: Car) = (0 until car.distance)
        .joinToString(prefix = "${car.name} : ", separator = "") { "_" }
}
