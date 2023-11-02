package racinggame

import racinggame.domain.Car
import racinggame.domain.RacingGame
import racinggame.domain.RandomDice
import racinggame.view.InputView
import racinggame.view.OutputView

fun main() {
    val carNames = InputView.getCarNames()
    val tryCount = InputView.getTryCount()

    val game = RacingGame(
        carNames.map { Car(name = it) },
        tryCount,
        RandomDice()
    )

    val result = game.play()
    val winners = game.getWinners()

    OutputView.printRacingResult(result)
    OutputView.printWinners(winners)
}
