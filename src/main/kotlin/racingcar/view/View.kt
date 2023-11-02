package racingcar.view

import racingcar.domain.RacingResult
import racingcar.domain.RacingResult.RacingHistory
import racingcar.util.Message
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

    fun racingResultPrint(racingResult: RacingResult) {
        val result =
            """
            |${Message.RACE_RESULT_FIRST_LINE.message}
            |${getRacingHistoryPrintFormat(racingResult, Message.CAR_RACING_MOVING_SYMBOL.message)}
            |
            |${getRacingWinnerPrintFormat(racingResult)}
            """.trimMargin()
        println(result)
    }

    private fun getRacingHistoryPrintFormat(racingResult: RacingResult, symbol: String) =
        racingResult.allRounds
            .joinToString("\n\n") { getNameAndSymbol(it, symbol) }

    private fun getNameAndSymbol(histories: List<RacingHistory>, symbol: String) =
        histories.joinToString("\n") { "${it.name} : ${symbol.repeat(it.move)}" }

    private fun getRacingWinnerPrintFormat(result: RacingResult): String =
        result.getRacingWinners()
            .joinToString(", ") { it.name }
            .plus(Message.WINNER_LINE.message)
}
