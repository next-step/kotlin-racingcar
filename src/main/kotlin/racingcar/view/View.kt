package racingcar.view

import racingcar.util.Environment
import racingcar.util.Message
import java.lang.IllegalArgumentException

object View {

    fun printAndGetLineToInt(input: Message, error: Message): Int {
        Environment.CAR_RACING_RANDOM_RANGE.random()
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
}
