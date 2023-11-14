package racingcar.view

import racingcar.domain.Car
import racingcar.domain.Cars

fun printRacing(racingCars: Cars) {
    racingCars.cars.forEach {
        println("${it.name} : ${"-".repeat(maxOf(0, it.position))}")
    }
    println()
}

fun printWinner(winnerCars: List<Car>): String = buildString {
    val winnersCarNames = winnerCars
        .joinToString(",") { it.name }

    println("${winnersCarNames}가 최종 우승했습니다.")
}
