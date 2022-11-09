package game.racingcar

import game.racingcar.domain.RacingCarGame
import game.racingcar.view.InputView
import game.racingcar.view.OutputView

fun main() {
    val (carNames, numberOfTrials) = InputView.getInputFromConsole()

    val racingCarGame = RacingCarGame(carNames, numberOfTrials)
    val racingCarPlayResult = racingCarGame.play()

    OutputView.printOutputToConsole(racingCarPlayResult)
}
