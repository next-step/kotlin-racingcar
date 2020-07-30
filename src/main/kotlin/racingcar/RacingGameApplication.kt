package racingcar

import racingcar.InputView.getCarNames
import racingcar.InputView.getRunCnt

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
