package racingcar

import racingcar.controller.RacingGame
import racingcar.view.InputView

fun main() {
    val carNames = InputView().inputCarNames()
    val tryNum = InputView().inputTryNum()

    val racingGame = RacingGame(carNames)
    println("\n실행 결과")
    racingGame.start(tryNum)
}
