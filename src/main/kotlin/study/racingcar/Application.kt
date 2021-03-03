package study.racingcar

import study.racingcar.domain.RaceResult
import study.racingcar.service.RacingCarGame
import study.racingcar.ui.InputView
import study.racingcar.ui.ResultView

fun main() {
    val carCount = InputView.inputCarCount()
    val tryCount = InputView.inputTryCount()
    val game = RacingCarGame(carCount, tryCount)
    game.start()
    val results: List<RaceResult> = game.getRaceResults()
    ResultView.doResult(results)
}
