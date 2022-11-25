package step3.racingcar.view

import step3.racingcar.domain.Car
import step3.racingcar.domain.Cars
import step3.racingcar.domain.Winners

class ResultView {
    companion object {
        private const val SCORE_BAR = "-"
        private const val ROUND_COMPLETE_GUIDE_MESSAGE_FORMAT = "%d 라운드가 종료되었습니다."
        private const val WINNER_GUIDE_MESSAGE_FORMAT = "%s 가 최종 우승했습니다."

        fun printRoundResult(currentRoundIndex: Int, cars: Cars) {
            roundCompleteGuideMessage(currentRoundIndex)
            cars.elements().forEach(::printEachCarRoundResult)
        }

        private fun roundCompleteGuideMessage(currentRoundIndex: Int) {
            println()
            println(ROUND_COMPLETE_GUIDE_MESSAGE_FORMAT.format(currentRoundIndex.plus(1)))
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

        fun printWinner(winners: Winners) {
            println()
            println(WINNER_GUIDE_MESSAGE_FORMAT.format(winners.names))
        }
    }
}
