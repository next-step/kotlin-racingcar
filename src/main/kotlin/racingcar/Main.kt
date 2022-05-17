package racingcar

import racingcar.controller.RacingGame
import racingcar.domain.NameLengthLimitStrategy
import racingcar.domain.RandomNumberStrategy
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
    ResultView.showRaceWinner(racingGame.getWinners())
}
