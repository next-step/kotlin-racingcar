package racingcar.ui

import racingcar.domain.RacingGame
import kotlin.random.Random

fun main() {
    val inputView = InputView().also {
        it.show()
    }
    val racingGame = RacingGame(
        carSize = inputView.carSize,
        attemptSize = inputView.attemptSize
    )
    val resultView = ResultView()

    repeat(inputView.attemptSize) {
        racingGame.attempt(
            List(racingGame.carSize) {
                Random.nextInt(RacingGame.MAX_CONDITION)
            }
        )
    }
    resultView.printRacingGameHistory(racingGame.history)
}
