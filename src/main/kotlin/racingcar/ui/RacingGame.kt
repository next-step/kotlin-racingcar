package racingcar.ui

import input.SystemInputStrategy
import racingcar.GameConfiguration

fun main() {
    GameConfiguration(
        attemptToGetInput("자동차 대수는 몇 대인가요?").value,
        attemptToGetInput("시도할 횟수는 몇 회인가요?").value
    )
}

private fun attemptToGetInput(question: String): InputView {
    return try {
        InputView(question, SystemInputStrategy())
    } catch (e: Exception) {
        attemptToGetInput(question)
    }
}
