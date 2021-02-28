package racingcar

import racingcar.model.Game
import racingcar.ui.InputView

private val game = Game()
private val inputView = InputView()

fun main() {
    val numberOfCar = inputView.inputNumberOfCar()
    val numberOfTimes = inputView.inputNumberOfTimes()

    game.createCar(numberOfCar)
    print("\n[실행 결과]")
    repeat(numberOfTimes) {
        game.executeOneCycle()
        game.printOneCycle()
    }
}
