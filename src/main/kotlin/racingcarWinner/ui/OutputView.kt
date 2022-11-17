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
    private const val ESCAPE_DOUBLE_LINE = "\n\n"

    fun outputResult(cars: List<Car>, winner: Winner, tryNumber: Int) {
        println(MessageCode.Result.message)
        print(tryAllRacingOutput(cars, winner, tryNumber))
    }

    fun outputWinner(cars: List<Car>, winner: Winner) {
        val winnerList = winner.getWinner(cars).joinToString(COMMA)
        println(ESCAPE_LINE.plus(winnerList).plus(MessageCode.WinnerResult.message))
    }

    private fun toMoveStepOutput(moveStep: Int): String =
        (WinnerRacing.INIT_TRY_NUMBER..moveStep).joinToString(SEPARATOR) { MOVE_STEP }

    private fun tryOneRacingOutput(cars: List<Car>, winner: Winner, tryNumber: Int): String =
        WinnerRacing.startRacing(cars, winner, tryNumber).joinToString(ESCAPE_LINE) { car ->
            car.carName.plus(COLON).plus(toMoveStepOutput(car.moveStep))
        }

    private fun tryAllRacingOutput(cars: List<Car>, winner: Winner, tryNumber: Int): String =
        (WinnerRacing.INIT_TRY_NUMBER..tryNumber).joinToString(ESCAPE_DOUBLE_LINE) {
            tryOneRacingOutput(cars, winner, it)
        }
}
