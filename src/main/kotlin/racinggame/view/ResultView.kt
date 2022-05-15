package racinggame.view

import racinggame.domain.model.IndividualRacingStepStatus
import racinggame.domain.model.RacingGameResult
import racinggame.domain.model.RacingStepResult

object ResultView {
    private const val RESULT_TITLE = "실행 결과"
    private const val PROCEED_LEVEL_SYMBOL = "-"
    private const val WINNER_TEXT_JOIN_SEPARATOR = ", "

    fun showResult(result: RacingGameResult) {
        println(RESULT_TITLE)
        printEntireRacingGameResult(result.stepResults)
        printWinners(result.winners)
    }

    private fun printEntireRacingGameResult(result: List<RacingStepResult>) {
        result.forEach { racingStepResult ->
            printRacingStep(racingStepResult)
        }
    }

    private fun printRacingStep(racingStepResult: RacingStepResult) {
        racingStepResult.racingGameStatusList.forEach { racingGameStatus ->
            printRacingGameStatus(racingGameStatus)
        }
        println()
    }

    private fun printRacingGameStatus(racingGameStatus: IndividualRacingStepStatus) {
        println(getRacingStepStatusText(racingGameStatus))
    }

    private fun getRacingStepStatusText(
        racingGameStatus: IndividualRacingStepStatus
    ) = "${racingGameStatus.name} : ${getCarProceedImage(racingGameStatus.proceedLevel)}"

    private fun getCarProceedImage(proceedLevel: Int) = PROCEED_LEVEL_SYMBOL.repeat(proceedLevel)

    private fun printWinners(winners: List<String>) {
        println("${getWinnersText(winners)}가 최종 우승했습니다.")
    }

    private fun getWinnersText(winners: List<String>) = winners.joinToString(WINNER_TEXT_JOIN_SEPARATOR)
}
