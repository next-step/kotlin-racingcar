package racingcar

import racingcar.domain.CarFactory
import racingcar.domain.RacingGame
import racingcar.domain.strategy.RandomNumStrategy
import racingcar.view.InputView
import racingcar.view.ResultView

fun main() {
    val carNames: List<String> = InputView.getCarName()
    var game = RacingGame(CarFactory.manufacture(carNames))
    val tryNum = InputView.getTryNum()

    ResultView.startPrintGame()

    for (i in 0 until tryNum) {
        game.play(RandomNumStrategy())
        ResultView.printGameResult(game)
    }
    ResultView.printGameWinner(game.getWinners())
}
