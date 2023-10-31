package step4.domain

import step4.presentation.ResultView

data class RacingGame(
    val inputView: InputView<RacingCourse>,
    val resultView: ResultView
) {
    fun run() {
        val racingCourse = inputView.enter()

        racingCourse.moveCars {
            resultView.showCarMoveView(it)
        }
        resultView.showFinalResultView(racingCourse.racingCars.winner)
    }
}
