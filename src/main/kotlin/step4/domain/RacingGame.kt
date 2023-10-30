package step4.domain

import step4.presentation.InputView
import step4.presentation.ResultView

data class RacingGame(
    val inputView: InputView,
    val resultView: ResultView
) {
    fun run() {
        val racingCars = inputView.enterCars()
        val tryCount = inputView.enterTryCount()
        val racingCourse = RacingCourse(tryCount, racingCars)

        racingCourse.moveCars {
            resultView.showCarMoveView(it)
        }
        resultView.showFinalResultView(racingCars.winner)
    }
}
