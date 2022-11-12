package racingcar.ui

import racingcar.core.Racing

object ResultView {
    private const val ESCAPE_LINE = "\n"
    private const val ESCAPE_DOUBLE_LINE = "\n\n"
    fun output(carNumber: Int, tryNumber: Int) {
        println(MessageCode.Result.message)
        print(tryAllRacingOutput(carNumber, tryNumber))
    }

    private fun tryOneRacingOutput(tryNumber: Int): String =
        Racing.startRacing(tryNumber).joinToString(ESCAPE_LINE)

    private fun tryAllRacingOutput(carNumber: Int, tryNumber: Int): String {
        Racing.setCars(carNumber)
        return (1..tryNumber).joinToString(ESCAPE_DOUBLE_LINE) {
            tryOneRacingOutput(tryNumber)
        }
    }
}
