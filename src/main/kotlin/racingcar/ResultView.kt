package racingcar

class ResultView {
    fun printGameHistory(gameResult: GameResults) {
        val gameResults = gameResult.gameResult
        gameResults.forEach { stage ->
            printStageResult(stage)

            println()
        }
    }

    private fun printStageResult(stage: List<CarResult>) {
        stage.forEach { car ->
            val positionResult = "-".repeat(car.position)
            println("${car.name} : $positionResult")
        }
    }

    fun printWinnerResult(winnerResultList: List<String>) {
        val namesList = winnerResultList.joinToString(WINNER_DELIMITER)
        val winnerMessage = "$namesList$WINNER_MSG_POSTFIX"
        print(winnerMessage)
    }

    companion object {
        private const val WINNER_MSG_POSTFIX = " 가 최종 우승하였습니다."
        private const val WINNER_DELIMITER = ", "
    }
}
