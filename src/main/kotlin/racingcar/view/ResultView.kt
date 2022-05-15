package racingcar.view

import racingcar.domain.CarResult

class ResultView {
    fun printGameHistory(gameHistory: List<List<CarResult>>) {
        gameHistory.forEach { stage ->
            printStageResult(stage)

            println()
        }
    }

    private fun printStageResult(stage: List<CarResult>) {
        stage.forEach { car ->
            val positionResult = CAR_POSITION_INDICATOR.repeat(car.position)
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
        private const val CAR_POSITION_INDICATOR = "-"
    }
}
