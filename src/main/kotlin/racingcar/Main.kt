package racingcar

import racingcar.controller.RacingGame
import racingcar.domain.strategy.NameLengthLimitStrategy
import racingcar.domain.strategy.RandomNumberStrategy
import racingcar.view.InputView
import racingcar.view.ResultView

fun main() {
    val carNames = InputView.getNumberOfCarByConsole()
    val trialCount = InputView.getTrialCountByConsole()
    val moveStrategy = RandomNumberStrategy()
    val nameStrategy = NameLengthLimitStrategy()

    val racingGame = RacingGame(carNames, trialCount, moveStrategy, nameStrategy)

    racingGame.play()
    ResultView.showAllRacingRecords(racingGame.results)
    ResultView.showRaceWinner(racingGame.getWinners())
}
