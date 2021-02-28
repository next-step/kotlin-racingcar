package racingcar

import racingcar.model.Game
import racingcar.ui.InputView

private val inputView = InputView()

fun main() {
    val numberOfCar = inputView.inputNumberOfCar()
    val numberOfTimes = inputView.inputNumberOfTimes()

    val game = Game(numberOfCar)
    println("\n[실행 결과]")
    repeat(numberOfTimes) {
        game.executeOneCycle()
        game.printOneCycle()
    }
}
