package racingcar.view

import racingcar.domain.RacingHistories
import racingcar.domain.RacingHistories.*
import racingcar.util.Message
import racingcar.util.Message.*
import java.lang.IllegalArgumentException

object View {

    fun printAndGetLine(input: Message, error: Message): String {
        ResultView.print(input.message)
        return InputView.getLine(error.message)
    }

    fun printAndGetLineToInt(input: Message, error: Message): Int {
        ResultView.print(input.message)
        return InputView.getLineToInt(error.message)
    }
}

object InputView {

    fun getLineToInt(errorMessage: String): Int {
        val input = getLine(errorMessage)
        return input.toIntOrNull() ?: throw IllegalArgumentException(errorMessage)
    }

    fun getLine(errorMessage: String) = readlnOrNull() ?: throw IllegalArgumentException(errorMessage)
}

object ResultView {

    fun print(message: String) {
        println(message)
    }

    fun racingResultPrint(racingHistories: RacingHistories) {
        val result = buildString {
            this.append(RACE_RESULT_FIRST_LINE.message).append("\n")
            racingHistories.getRacingHistories().forEach { it ->
                this.append(getNameAndSymbol(it, CAR_RACING_MOVING_SYMBOL.message))
                    .append("\n\n")
            }
            this.append(getWinner(racingHistories.getRacingHistories().last()))
        }
        println(result)
    }

    private fun getNameAndSymbol(histories: List<RacingHistory>, symbol: String) =
        histories.joinToString("\n") { "${it.name} : ${CAR_RACING_MOVING_SYMBOL.message.repeat(it.move)}" }

    private fun getWinner(histories: List<RacingHistory>): String {
        val max = histories.maxBy(RacingHistory::move)
        return histories.filter { max.move == it.move }
            .toList()
            .joinToString(", ") { it.name }
            .plus(WINNER.message)
    }

}
