package racingcar.ui

import racingcar.domain.RacingGame
import kotlin.random.Random

fun main() {
    val inputView = InputView().also {
        it.show()
    }
    val racingGame = RacingGame(
        carNames = inputView.carNames,
        attemptSize = inputView.attemptSize
    )
    val resultView = ResultView()

    repeat(inputView.attemptSize) {
        racingGame.attempt(
            List(racingGame.cars.size) {
                Random.nextInt(RacingGame.MAX_CONDITION)
            }
        )
    }
    resultView.printRacingGameHistory(racingGame)
}
