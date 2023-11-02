package racingcar.ui

import racingcar.domain.RacingGame

fun main() {
    val inputView = InputView().also {
        it.show()
    }
    val racingGame = RacingGame(
        carSize = inputView.carSize,
        attemptSize = inputView.attemptSize
    )
    val resultView = ResultView()

    repeat(inputView.carSize) {
        racingGame.attempt()
        resultView.printCarPositions(racingGame.getCarPositions())
    }
}
