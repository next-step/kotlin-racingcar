package step3.racingcar.view

import step3.racingcar.domain.Car

class ResultView {
    companion object {
        private const val SCORE_BAR = "-"
        private val result: StringBuilder = StringBuilder()

        fun printEachCarScore(car: Car) {
            for (i in 0 until car.moveCount()) {
                result.append(SCORE_BAR)
            }
            println(result)
        }

        fun roundResultGuideMessage(currentRound: Int) {
            println("`$currentRound`라운드가 종료되었습니다.")
        }
    }
}
