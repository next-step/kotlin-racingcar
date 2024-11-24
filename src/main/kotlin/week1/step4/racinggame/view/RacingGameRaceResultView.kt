package week1.step4.racinggame.view

import week1.step4.racinggame.domain.Car

class RacingGameRaceResultView {
    companion object {
        fun announceRoundResult(cars: List<Car>) {
            cars.forEach {
                print("${it.carName.value} : ")
                println("-".repeat(it.position))
            }
            println()
        }

        fun announceRaceWinners(winners: List<Car>) {
            println("${winners.joinToString(", ") { it.carName.value }}가 최종 우승했습니다.")
        }
    }
}
