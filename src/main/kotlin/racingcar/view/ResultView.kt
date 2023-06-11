package racingcar.view

import racingcar.model.RacingCars
import racingcar.model.RacingHistory
import racingcar.model.RacingReferee

fun printResult(history: RacingHistory) {
    println("실행 결과")
    history.forEach {
        printCars(it)
        println()
    }
}

private fun printCars(cars: RacingCars) {
    cars.forEach {
        println("${it.name} : ${DISTANCE_SIGN.repeat(it.wentDistance)}")
    }
}

fun printWinners(referee: RacingReferee) {
    println("${referee.winners.names.joinToString(", ")}가 최종 우승했습니다.")
}

private const val DISTANCE_SIGN = "-"
