package racingcar

import racingcar.car.Car
import racingcar.car.engine.RandomEngine
import racingcar.view.InputView

class GameBoard(minCarCount: Int = 1, minMoveCount: Int = 1) {
    private val inputView = InputView(minCarCount, minMoveCount)
    val cars = inputView.carNames.map { Car(RandomEngine(), it) }
    val moveCount = inputView.moveCount.value
}
