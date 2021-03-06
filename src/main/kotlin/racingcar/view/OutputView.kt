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
    val value = car.distance.value
    val stringBuilder = StringBuilder()
    (0 until value).map { stringBuilder.append("-") }

    println(stringBuilder.toString())
}
