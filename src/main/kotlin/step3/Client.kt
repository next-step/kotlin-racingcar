package step3

import step3.domain.Cars
import step3.domain.RacingGame
import step3.domain.RandomRule
import step3.view.InputView
import step3.view.OutputView

fun main() {
    val (carNames, lapCount) = InputView.handleInput()

    val cars = Cars.fromNames(carNames)
    val racingGame = RacingGame(cars, RandomRule())

    val lapResults = racingGame.play(lapCount)

    OutputView.handleOutput(lapResults)
}
