package racingcar.resultviews

class RacingGameResultView : ResultView {
    override fun printResult(gameResult: GameResult) {
        for (roundResult in gameResult.roundResults) {
            printRoundResult(roundResult)
        }
    }

    private fun printRoundResult(roundResult: RoundResult) {
        for (position in roundResult.positions) {
            println("-".repeat(position))
        }
        println("")
    }
}
