package racingcarWinner.ui

import racingcarWinner.core.MessageCode
import racingcarWinner.core.WinnerRacing

object OutputView {
    private const val MOVE_STEP = "-"
    private const val SEPARATOR = " "
    private const val COLON = " : "
    private const val ESCAPE_LINE = "\n"
    private const val ESCAPE_DOUBLE_LINE = "\n\n"

    fun outputResult(racing: WinnerRacing, tryNumber: Int) {
        println(MessageCode.Result.message)
        print(tryAllRacingOutput(racing, tryNumber))
    }

    fun outputWinner(racing: WinnerRacing) {
        val winnerList = racing.getWinner(racing.cars, racing.maxMoveStep).joinToString(SEPARATOR)
        println(ESCAPE_LINE.plus(winnerList).plus(MessageCode.WinnerResult.message))
    }

    private fun toMoveStepOutput(moveStep: Int): String =
        (WinnerRacing.INIT_TRY_NUMBER..moveStep).joinToString(SEPARATOR) { MOVE_STEP }

    private fun tryOneRacingOutput(racing: WinnerRacing, tryNumber: Int): String =
        racing.startRacing(tryNumber).map { carMap ->
            carMap.key.plus(COLON).plus(toMoveStepOutput(carMap.value))
        }.joinToString(ESCAPE_LINE)

    private fun tryAllRacingOutput(racing: WinnerRacing, tryNumber: Int): String =
        (WinnerRacing.INIT_TRY_NUMBER..tryNumber).joinToString(ESCAPE_DOUBLE_LINE) {
            tryOneRacingOutput(racing, tryNumber)
        }
}
