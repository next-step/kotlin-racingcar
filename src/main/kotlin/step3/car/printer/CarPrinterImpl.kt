package step3.car.printer

import step3.car.Car

class CarPrinterImpl : CarPrinter {
    override fun print(car: Car) {
        repeat(car.distance) { print("_") }
        println()
    }
}
