package racingcar.view

import racingcar.domain.Car
import racingcar.domain.Cars
import racingcar.domain.RacingResult
import racingcar.domain.Winners

private const val DISTANCE_SYMBOL = "-"

fun printResult(result: RacingResult, winners: Winners) {
    println("실행결과")
    result.elements
        .forEach { printCars(it) }

    println("${winners.elements.joinToString { it.name.value }} 가 최종 우승했습니다.")
}

private fun printCars(cars: Cars) {
    cars.elements
        .forEach { printCar(it) }
    println()
}

private fun printCar(car: Car) {
    println("${car.name.value} : ${DISTANCE_SYMBOL.repeat(car.distance.value)}")
}
