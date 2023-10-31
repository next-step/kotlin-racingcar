package study.racingcar

import study.racingcar.application.InputView
import study.racingcar.application.OutputView
import study.racingcar.application.StdinReader
import study.racingcar.domain.RacingGame

/**
 * entrance point
 * */
class MainUI

fun main() {
    val racingGame = RacingGame(InputView(StdinReader()), OutputView())
    racingGame.run()
}
