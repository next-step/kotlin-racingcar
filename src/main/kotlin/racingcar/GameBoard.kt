package racingcar

import racingcar.car.Car
import racingcar.car.engine.RandomEngine
import racingcar.view.InputView

class GameBoard(minCarCount: Int = 1, minMoveCount: Int = 1) {
    private val inputView = InputView(minCarCount, minMoveCount)
    val cars = List(inputView.carCount.value) { Car(RandomEngine()) }
    val moveCount = inputView.moveCount.value
}
