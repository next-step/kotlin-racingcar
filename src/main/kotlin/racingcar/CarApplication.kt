package racingcar

import racingcar.io.InputView
import racingcar.io.ResultView

fun main() {
    val (numberOfCars, numberOfTry) = InputView.read()
    val game = Game(numberOfCars, numberOfTry)
    val gameResult = game.execute()
    ResultView.print(gameResult)
}
