package racingcar

import racingcar.InputView.getCarNames
import racingcar.InputView.getRunCnt
import racingcar.RacingGame.Companion.tracks

fun main(args: Array<String>) {
    var carNames = getCarNames()
    var runCnt = getRunCnt()
    val game = RacingGame(carNames, runCnt)

    ResultView.showResultTitle()

    while (!game.isOver()) {
        game.runOnce()
        ResultView.showRace(tracks)
        tracks.clear()
    }
    ResultView.showWinner(game.findWinners())
}
