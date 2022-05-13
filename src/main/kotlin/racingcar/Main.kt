package racingcar

import racingcar.car.RacingGame
import racingcar.car.strategy.RandomNumberStrategy
import racingcar.view.InputView
import racingcar.view.ResultView

fun main() {
    val numberOfCar = InputView.getNumberOfCarByConsole()
    val trialCount = InputView.getTrialCountByConsole()
    val strategy = RandomNumberStrategy()

    val racingGame = RacingGame.init(numberOfCar, trialCount, strategy)

    repeat(racingGame.trialCount) {
        racingGame.play()
        ResultView.showRecordsAsDash(racingGame.getPlayResults())
    }
}
