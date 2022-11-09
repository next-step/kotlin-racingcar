package step3.racingcar.view

import step3.racingcar.domain.Car
import step3.racingcar.domain.Cars
import step3.racingcar.domain.RoundResult

class ResultView {
    companion object {
        private const val SCORE_BAR = "-"

        private fun roundResultGuideMessage(currentRound: Int) {
            println("[$currentRound] 라운드 결과")
            println()
        }

        fun printResult(roundCount: Int, cars: Cars) {
            println()
            for (i in 1..roundCount) {
                printEachCarsRoundScore(i, cars)
                roundResultGuideMessage(i)
            }
        }

        private fun printEachCarsRoundScore(currentRound: Int, cars: Cars) {
            cars.elements.forEach {
                printEachRoundScore(currentRound, it)
            }
        }

        private fun printEachRoundScore(currentRound: Int, car: Car) {
            val result: StringBuilder = StringBuilder()
            for (i in 0 until currentRound) {
                val roundResult = car.roundResults.elements()[i]
                addScoreBar(roundResult, result)
            }
            println("${car.id} : $result")
        }

        private fun addScoreBar(roundResult: RoundResult, result: StringBuilder) {
            if (roundResult.moveStatus.isGo()) {
                result.append(SCORE_BAR)
            }
        }
    }
}
