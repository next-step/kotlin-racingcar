package step3.racingcar.view

import step3.racingcar.domain.Car
import step3.racingcar.domain.Cars

class ResultView {
    companion object {
        private const val SCORE_BAR = "-"

        fun printRoundResult(currentRound: Int, cars: Cars) {
            println()
            println("${currentRound}라운드가 종료되었습니다.")
            cars.elements().forEach(::printEachCarRoundResult)
        }

        private fun printEachCarRoundResult(car: Car) {
            println("${car.name} : ${distanceToScore(car.distance)}")
        }

        private fun distanceToScore(distance: Int): StringBuilder {
            val result: StringBuilder = StringBuilder()
            repeat(distance) {
                result.append(SCORE_BAR)
            }
            return result
        }
    }
}
