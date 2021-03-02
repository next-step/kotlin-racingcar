package racingcar_winner

import racingcar_winner.model.CarFactory
import racingcar_winner.model.Game
import racingcar_winner.ui.InputView

private val inputView = InputView()
private val carFactory = CarFactory()

fun main() {
    val carNames = inputView.inputCarNames()
    val numberOfRound = inputView.inputNumberOfRound()

    val cars = carFactory.orderMakingCars(carNames)

    val game = Game(numberOfRound, cars)
    game.playGame()
}
