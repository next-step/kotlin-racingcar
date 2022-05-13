package racing.view

import racing.domain.RacingCars
import racing.domain.Winners

object RacingUI {

    fun drawCars(racingCars: RacingCars) {
        racingCars.cars.forEach { car ->
            println("${car.name} : ${"-".repeat(car.position + 1)}")
        }
        println()
    }

    fun drawWinners(winners: Winners) {
        val winnerMessage = winners.cars
            .joinToString(separator = ", ", postfix = "가 최종 우승했습니다.") {
                it.name
            }
        println(winnerMessage)
    }
}
