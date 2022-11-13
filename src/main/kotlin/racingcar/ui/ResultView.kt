package racingcar.ui

import racingcar.core.Racing

object ResultView {
    private const val MOVE_STEP = "-"
    private const val SEPARATOR = " "
    private const val ESCAPE_LINE = "\n"
    private const val ESCAPE_DOUBLE_LINE = "\n\n"
    fun output(carNumber: Int, tryNumber: Int) {
        println(MessageCode.Result.message)
        print(tryAllRacingOutput(carNumber, tryNumber))
    }

    private fun toMoveStepOutput(moveStep: Int): String =
        (Racing.INIT_TRY_NUMBER..moveStep).joinToString(SEPARATOR) { MOVE_STEP }

    private fun tryOneRacingOutput(tryNumber: Int): String =
        Racing.startRacing(tryNumber).joinToString(ESCAPE_LINE) { carMoveStep ->
            toMoveStepOutput(carMoveStep)
        }

    private fun tryAllRacingOutput(carNumber: Int, tryNumber: Int): String {
        Racing.setCars(carNumber)
        return (1..tryNumber).joinToString(ESCAPE_DOUBLE_LINE) {
            tryOneRacingOutput(tryNumber)
        }
    }
}
