package racingcar

import racingcar.domain.RacingGame
import racingcar.view.InputView.getCarNames
import racingcar.view.InputView.getRunCnt
import racingcar.view.ResultView

fun main(args: Array<String>) {
    var carNames = getCarNames()
    var runCnt = getRunCnt()
    val game = RacingGame(carNames, runCnt)

    ResultView.showResultTitle()

    while (!game.isOver()) {
        game.runOnce()
        ResultView.showRace(game.carsOnTrack)
        game.clearTrack()
    }
    ResultView.showWinner(game.findWinners())
}
