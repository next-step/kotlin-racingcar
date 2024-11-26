package racingcar.view

import racingcar.domain.Cars
import racingcar.domain.Winners

object OutputView {
    fun gameResult(cars: Cars) {
        cars.cars.forEach {
            println(it.username + " : " + it.position.viewPosition())
        }
        println()
    }

    fun gameWinner(cars: Cars) {
        val winners = Winners(cars)
        val winnersName = winners.getWinnerNames().joinToString(",")
        println(winnersName + "가 최종 우승했습니다.")
    }
}
