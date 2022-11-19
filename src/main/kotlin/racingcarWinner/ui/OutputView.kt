package racingcarWinner.ui

import racingcarWinner.domain.Car
import racingcarWinner.util.MessageCode

object OutputView {
    private const val MOVE_STEP = "-"
    private const val SEPARATOR = " "
    private const val COMMA = ", "
    private const val COLON = " : "
    private const val ESCAPE_LINE = "\n"

    fun outputResult() {
        println(MessageCode.Result.message)
    }

    fun printTryOneRacingOutput(racingCars: List<Car>) {
        println(tryOneRacingOutput(racingCars).plus(ESCAPE_LINE))
    }

    fun outputWinner(winnerList: List<String>) {
        println(winnerList.joinToString(COMMA).plus(MessageCode.WinnerResult.message))
    }

    private fun toMoveStepOutput(moveStep: Int): String =
        (InputView.INIT_TRY_NUMBER..moveStep).joinToString(SEPARATOR) { MOVE_STEP }

    private fun tryOneRacingOutput(racingCars: List<Car>): String =
        racingCars.joinToString(ESCAPE_LINE) { car ->
            car.carName.plus(COLON).plus(toMoveStepOutput(car.moveStep))
        }
}
