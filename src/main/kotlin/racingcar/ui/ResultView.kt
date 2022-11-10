package racingcar.ui

import racingcar.core.Racing

object ResultView {
    private const val ESCAPE_LINE = "\n"
    private const val ESCAPE_DOUBLE_LINE = "\n\n"
    private val racing = Racing()
    fun output(carNumber: Int, tryNumber: Int) {
        println(MessageCode.Result.message)
        print(tryAllRacingOutput(carNumber, tryNumber))
    }

    private fun tryOneRacingOutput(carNumber: Int, tryNumber: Int): String =
        racing.startRacing(carNumber, tryNumber).joinToString(ESCAPE_LINE)

    private fun tryAllRacingOutput(carNumber: Int, tryNumber: Int): String =
        (1..tryNumber).joinToString(ESCAPE_DOUBLE_LINE) {
            tryOneRacingOutput(carNumber, tryNumber)
        }
}
