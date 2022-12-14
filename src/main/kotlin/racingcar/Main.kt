package racingcar

import racingcar.view.InputView
import racingcar.view.ResultWithNameView

fun main() {
    val racingCarGame = InputView.receiveInput()
    val gameSnapShots = racingCarGame.startGame()
    ResultWithNameView.prettyPrint(gameSnapShots)
}
