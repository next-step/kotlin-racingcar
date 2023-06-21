package racingcar

import racingcar.domain.RacingGame
import racingcar.view.InputView
import racingcar.view.ResultView

fun main() {
    val numberOfCars = InputView.requestNumberOfCars()
    val round = InputView.requestRound()

    val racingGame = RacingGame(round, numberOfCars)
    racingGame.run()

    val histories = racingGame.getHistories()
    ResultView.printHistory(histories)
}
