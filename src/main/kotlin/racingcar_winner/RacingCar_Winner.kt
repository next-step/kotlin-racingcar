package racingcar_winner

import racingcar_winner.model.CarManager
import racingcar_winner.model.Game
import racingcar_winner.ui.InputView

private val inputView = InputView()
private val carManager = CarManager()

fun main() {
    val carNames = inputView.inputCarNames()
    val numberOfRound = inputView.inputNumberOfRound()

    val cars = carManager.orderMakingCars(carNames)

    val game = Game(numberOfRound, cars)
    game.playGame()
}
