package racingcarWinner.ui

import racingcarWinner.domain.Car
import racingcarWinner.domain.Winner
import racingcarWinner.domain.WinnerRacing
import racingcarWinner.util.MessageCode

object OutputView {
    private const val MOVE_STEP = "-"
    private const val SEPARATOR = " "
    private const val COMMA = ", "
    private const val COLON = " : "
    private const val ESCAPE_LINE = "\n"

    fun outputResult() {
        println(ESCAPE_LINE.plus(MessageCode.Result.message))
    }

    fun printTryOneRacingOutput(cars: List<Car>) {
        println(tryOneRacingOutput(cars).plus(ESCAPE_LINE))
    }

    fun outputWinner(cars: List<Car>) {
        val winnerList = Winner.getWinner(cars).joinToString(COMMA)
        println(winnerList.plus(MessageCode.WinnerResult.message))
    }

    private fun toMoveStepOutput(moveStep: Int): String =
        (InputView.INIT_TRY_NUMBER..moveStep).joinToString(SEPARATOR) { MOVE_STEP }

    private fun tryOneRacingOutput(cars: List<Car>): String =
        WinnerRacing.startRacing(cars).joinToString(ESCAPE_LINE) { car ->
            car.carName.plus(COLON).plus(toMoveStepOutput(car.moveStep))
        }
}
