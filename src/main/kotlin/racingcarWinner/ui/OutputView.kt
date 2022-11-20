package racingcarWinner.ui

import racingcarWinner.domain.Car
import racingcarWinner.util.MessageCode

object OutputView {
    private const val MOVE_STEP = "-"
    private const val COMMA = ", "
    private const val COLON = ":"

    fun outputResult() {
        println(MessageCode.Result.message)
    }

    fun printTryOneRacingOutput(racingCars: List<Car>) {
        racingCars.forEach {
            println("${it.carName} $COLON ${MOVE_STEP.repeat(it.getMoveStep())}")
        }
        println()
    }

    fun outputWinner(winnerList: List<String>) {
        println(winnerList.joinToString(COMMA).plus(MessageCode.WinnerResult.message))
    }
}
