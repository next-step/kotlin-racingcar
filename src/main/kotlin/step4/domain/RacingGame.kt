package step4.domain

data class RacingGame(
    val inputView: InputView<RacingCourse>,
    val resultView: ResultView<RacingGameResultText>
) {
    fun run() {
        val racingCourse = inputView.enter()

        val resultText = RacingGameResultText()
        racingCourse.moveCars {
            resultText.saveMiddleResult(it)
        }
        resultText.saveFinalResultView(racingCourse.racingCars.winner)
        resultView.showResult(resultText)
    }
}
