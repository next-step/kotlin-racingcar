package racingcar.view

import racingcar.model.RacingCar
import racingcar.model.RacingHistory

fun printResult(history: RacingHistory) {
    println("실행 결과")
    history.forEach {
        printCars(it)
        println()
    }
}

private fun printCars(cars: Collection<RacingCar>) {
    cars.forEach {
        println(DISTANCE_SIGN.repeat(it.wentDistance))
    }
}

private const val DISTANCE_SIGN = "-"
