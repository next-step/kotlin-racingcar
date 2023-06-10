package study.racingcar

import study.racingcar.race.RacingGame
import study.racingcar.view.InputView
import study.racingcar.view.ResultView

fun main() {
    val input = InputView()
    val output = ResultView()
    val racingGame = RacingGame(input, output)
    racingGame.start()
}
