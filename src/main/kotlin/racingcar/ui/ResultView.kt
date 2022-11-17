package racingcar.ui

import racingcar.core.Racing

object ResultView {
    private const val MOVE_STEP = "-"
    private const val SEPARATOR = " "
    private const val ESCAPE_LINE = "\n"
    private const val ESCAPE_DOUBLE_LINE = "\n\n"
    fun output(racing: Racing, tryNumber: Int) {
        println(MessageCode.Result.message)
        print(tryAllRacingOutput(racing, tryNumber))
    }

    private fun toMoveStepOutput(moveStep: Int): String =
        (Racing.INIT_TRY_NUMBER..moveStep).joinToString(SEPARATOR) { MOVE_STEP }

    private fun tryOneRacingOutput(racing: Racing, tryNumber: Int): String =
        racing.startRacing(tryNumber).joinToString(ESCAPE_LINE) { carMoveStep ->
            toMoveStepOutput(carMoveStep)
        }

    private fun tryAllRacingOutput(racing: Racing, tryNumber: Int): String {
        return (1..tryNumber).joinToString(ESCAPE_DOUBLE_LINE) {
            tryOneRacingOutput(racing, tryNumber)
        }
    }
}
