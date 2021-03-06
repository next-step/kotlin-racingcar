package study.racingcar

import study.racingcar.service.RacingCarGame
import study.racingcar.ui.InputView
import study.racingcar.ui.ResultView

fun main() {
    val carNames = InputView.inputCarNames()
    val tryCount = InputView.inputTryCount()
    val game = RacingCarGame(carNames, tryCount)
    game.start()
    ResultView.doResult(game.raceResults, game.winners)
}
