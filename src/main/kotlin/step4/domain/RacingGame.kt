package step4.domain

data class RacingGame(
    val inputView: InputView<RacingCourse>,
    val resultView: ResultView<RacingGameResult>
) {
    fun run() {
        val racingCourse = inputView.enter()

        val gameResult = RacingGameResult()
        racingCourse.moveCars {
            gameResult.saveRacingResult(it)
        }
        resultView.showResult(gameResult)
    }
}
