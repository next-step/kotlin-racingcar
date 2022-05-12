package racinggame.view

import racinggame.domain.model.IndividualRacingStepStatus
import racinggame.domain.model.RacingStepResult

object ResultView {
    private const val RESULT_TITLE = "실행 결과"
    private const val PROCEED_LEVEL_SYMBOL = "-"

    fun showResult(result: List<RacingStepResult>) {
        println(RESULT_TITLE)
        printEntireRacingGameResult(result)
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
}
