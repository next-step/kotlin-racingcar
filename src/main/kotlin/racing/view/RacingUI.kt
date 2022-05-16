package racing.view

import racing.domain.RacingCars
import racing.domain.Winners

object RacingUI {

    fun drawCars(racingCars: RacingCars) {
        racingCars.forEach { name, position ->
            println("$name : ${"-".repeat(position + 1)}")
        }
        println()
    }

    fun drawWinners(winners: Winners) {
        val winnerMessage = winners.carNames
            .joinToString(separator = ", ", postfix = "가 최종 우승했습니다.")
        println(winnerMessage)
    }
}
