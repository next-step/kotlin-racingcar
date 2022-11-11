package game.racingcar

import game.racingcar.domain.RacingCarGame
import game.racingcar.domain.RacingCars
import game.racingcar.move.RandomMoveStrategy
import game.racingcar.view.InputView
import game.racingcar.view.OutputView

fun main() {
    val (carNames, numberOfTrials) = InputView.getInputFromConsole()

    val racingCars = RacingCars(carNames, RandomMoveStrategy())
    val racingCarGame = RacingCarGame(numberOfTrials, racingCars)
    val racingCarPlayResult = racingCarGame.play()

    OutputView.printOutputToConsole(racingCarPlayResult)
}
