package racinggame.view

import racinggame.domain.model.RacingStepStatus

object ResultView {
    private const val RESULT_TITLE = "실행 결과"
    private const val PROCEED_LEVEL_SYMBOL = "-"

    fun showResult(result: List<RacingStepStatus>) {
        println(RESULT_TITLE)
        printEntireRacingGameResult(result)
    }

    private fun printEntireRacingGameResult(result: List<RacingStepStatus>) {
        result.forEach { racingStepStatus ->
            printRacingStep(racingStepStatus)
        }
    }

    private fun printRacingStep(racingStepStatus: RacingStepStatus) {
        racingStepStatus.proceedLevels.forEach { level ->
            println(PROCEED_LEVEL_SYMBOL.repeat(level))
        }
        println()
    }
}
