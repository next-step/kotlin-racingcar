package racingcarWinner.ui

import racingcarWinner.core.Car
import racingcarWinner.core.MessageCode
import racingcarWinner.core.Winner
import racingcarWinner.core.WinnerRacing

object OutputView {
    private const val MOVE_STEP = "-"
    private const val SEPARATOR = " "
    private const val COMMA = ", "
    private const val COLON = " : "
    private const val ESCAPE_LINE = "\n"
    private const val ESCAPE_DOUBLE_LINE = "\n\n"

    fun outputResult(cars: List<Car>, racing: WinnerRacing, tryNumber: Int) {
        println(MessageCode.Result.message)
        print(tryAllRacingOutput(cars, racing, tryNumber))
    }

    fun outputWinner(cars: List<Car>, maxMoveStep: Int) {
        val winnerList = Winner.getWinner(cars, maxMoveStep).joinToString(COMMA)
        println(ESCAPE_LINE.plus(winnerList).plus(MessageCode.WinnerResult.message))
    }

    private fun toMoveStepOutput(moveStep: Int): String =
        (WinnerRacing.INIT_TRY_NUMBER..moveStep).joinToString(SEPARATOR) { MOVE_STEP }

    private fun tryOneRacingOutput(cars: List<Car>, racing: WinnerRacing, tryNumber: Int): String =
        racing.startRacing(cars, tryNumber).map { carMap ->
            carMap.key.plus(COLON).plus(toMoveStepOutput(carMap.value))
        }.joinToString(ESCAPE_LINE)

    private fun tryAllRacingOutput(cars: List<Car>, racing: WinnerRacing, tryNumber: Int): String =
        (WinnerRacing.INIT_TRY_NUMBER..tryNumber).joinToString(ESCAPE_DOUBLE_LINE) {
            tryOneRacingOutput(cars, racing, it)
        }
}
