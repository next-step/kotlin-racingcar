package racingcar

object ResultView : RacingGameEventListener {

    override fun notify(event: RacingGameEvent, racingGame: RacingGame) {
        when (event) {
            RacingGameEvent.STARTED -> printPositionsHeader()
            RacingGameEvent.MOVED -> printPositions(racingGame.positions())
            RacingGameEvent.FINISHED -> printWinners(racingGame.winners())
        }
    }

    private fun printPositionsHeader() {
        println("실행 결과")
    }

    private fun printPositions(positions: List<Position>) {
        val progressBar = positions.joinToString(separator = "\n", postfix = "\n") { "${it.name} : " + "-".repeat(it.position) }
        println(progressBar)
    }

    private fun printWinners(winners: List<String>) {
        val winnerNames = winners.joinToString(separator = ", ")
        println("${winnerNames}가 최종 우승했습니다.")
    }
}
