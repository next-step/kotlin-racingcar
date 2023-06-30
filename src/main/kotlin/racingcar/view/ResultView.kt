package racingcar.view

import racingcar.domain.Cars
import racingcar.domain.RaceHistory

fun printResult(history: RaceHistory) {
    println("실행 결과")
    history.history.forEach {
        printCars(it)
        println()
    }
}

private fun printCars(cars: Cars) {
    cars.forEach {
        println("${it.carName} : ${DISTANCE_SIGN.repeat(it.getPosition())}")
    }
}

fun printWinners(cars: Cars) {
    println("${cars.names.joinToString(", ")} 가 최종 우승했습니다.")
}

private const val DISTANCE_SIGN = "-"
