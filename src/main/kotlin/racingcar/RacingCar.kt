package racingcar

import racingcar.model.Game
import racingcar.ui.InputView

private val inputView = InputView()

fun main() {
    val numberOfCar = inputView.inputNumberOfCar()
    val numberOfTimes = inputView.inputNumberOfTimes()

    val game = Game()
    game.createCar(numberOfCar)

    println("\n[실행 결과]")
    repeat(numberOfTimes) {
        game.playOneRound()
    }
}
