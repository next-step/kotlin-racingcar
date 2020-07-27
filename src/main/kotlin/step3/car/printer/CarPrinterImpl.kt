package step3.car.printer

import step3.car.Car

class CarPrinterImpl : CarPrinter {
    override fun printString(car: Car) = (0 until car.distance)
        .joinToString(separator = "") { "_" }
}
