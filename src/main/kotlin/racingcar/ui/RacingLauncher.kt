package racingcar.ui

import input.SystemInputStrategy
import racingcar.Game
import racingcar.GameConfiguration
import racingcar.RandomMovingStrategy

fun main() {
    Game(
        GameConfiguration(
            attemptToGetInput("자동차 대수는 몇 대인가요?").value,
            attemptToGetInput("시도할 횟수는 몇 회인가요?").value
        ),
        RandomMovingStrategy()
    ).start()
}

private fun attemptToGetInput(question: String): InputView {
    return try {
        InputView(question, SystemInputStrategy())
    } catch (e: Exception) {
        attemptToGetInput(question)
    }
}
