package racingcar.view

import racingcar.domain.Car
import racingcar.domain.Cars
import racingcar.domain.RacingResult
import racingcar.domain.Winner

fun printResult(result: RacingResult) {
    println("실행결과")
    result.elements
        .forEach { printCars(it) }
}

private fun printCars(cars: Cars) {
    cars.elements
        .forEach { printCar(it) }
    println()
}

private fun printCar(car: Car) {
    println(car.name.value + " : " + "-".repeat(car.distance.value))
}

fun printWinner(winner: Winner) {
    println(winner.elements.joinToString { it.name.value } + "가 최종 우승했습니다.")
}
