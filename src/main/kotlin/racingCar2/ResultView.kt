package racingCar2

class ResultView {
    private fun showResultMessage() {
        println("실행 결과")
    }

    fun showRacingResult(gameRecords: MutableList<GameResult>, winners: List<String>) {
        this.showResultMessage()

        gameRecords.forEach {
            showCarPosition(it)
            println()
        }

        this.showWinners(winners)
    }

    private fun showWinners(winners: List<String>) {
        println("${winners.joinToString(", ")}가 최종 우승했습니다.")
    }

    private fun showCarPosition(gameResult: GameResult) {
        gameResult.players.forEach { player ->
            println("${player.name} : ${DISPLAY_STRING.repeat(player.position)}")
        }
    }

    companion object {
        const val DISPLAY_STRING = "-"
    }
}
