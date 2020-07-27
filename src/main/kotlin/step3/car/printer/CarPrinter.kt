package step3.car.printer

import step3.car.Car

interface CarPrinter {
    fun printString(car: Car): String
    fun print(car: Car) = println(printString((car)))
}
