package racingcar

import racingcar.car.Car
import racingcar.view.InputView

class GameBoard(minCarCount: Int = 1, minMoveCount: Int = 1) {
    private val inputView = InputView(minCarCount, minMoveCount)
    private val carCount = inputView.carCount.value
    val moveCount = inputView.moveCount.value
    val cars = List(carCount) { Car(moveCount) }
}
