package racingcar

import racingcar.car.RacingGame
import racingcar.car.strategy.NameLengthLimitStrategy
import racingcar.car.strategy.RandomNumberStrategy
import racingcar.view.InputView
import racingcar.view.ResultView

fun main() {
    val carNames = InputView.getNumberOfCarByConsole()
    val trialCount = InputView.getTrialCountByConsole()
    val moveStrategy = RandomNumberStrategy()
    val nameStrategy = NameLengthLimitStrategy()

    val racingGame = RacingGame(carNames, trialCount, moveStrategy, nameStrategy)

    repeat(racingGame.trialCount) {
        racingGame.play()
        ResultView.showRecordsAsDash(racingGame.getPlayResults())
    }
}
