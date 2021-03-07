package racingcar.view

import racingcar.domain.Car
import racingcar.domain.Cars

fun printResultMessage() = println("실행결과")
fun printCars(cars: Cars) {
    cars.elements
        .forEach { printCar(it) }
    println()
}

private fun printCar(car: Car) {
    println("-".repeat(car.distance.value))
}
