package racingcar.view

import racingcar.domain.RacingHistories
import racingcar.util.Message
import racingcar.util.Message.*
import java.lang.IllegalArgumentException

object View {

    fun printAndGetLineToInt(input: Message, error: Message): Int {
        ResultView.print(input.message)
        return InputView.getLineToInt(error.message)
    }
}

object InputView {

    fun getLineToInt(errorMessage: String): Int {
        val input = readlnOrNull() ?: throw IllegalArgumentException(errorMessage)
        return input.toIntOrNull() ?: throw IllegalArgumentException(errorMessage)
    }
}

object ResultView {

    fun print(message: String) {
        println(message)
    }

    fun racingResultPrint(racingHistories: RacingHistories) {
        val result = buildString {
            this.append(RACE_RESULT_FIRST_LINE.message).append("\n")
            racingHistories.getRacingHistories().forEach { racingHistory ->
                this.append(racingHistory.joinToString("\n") { it.getMovingSymbol(CAR_RACING_MOVING_SYMBOL.message) })
                    .append("\n\n")
            }
        }
        println(result)
    }
}
