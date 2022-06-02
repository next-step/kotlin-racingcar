package racingcar

import racingcar.car.Car
import racingcar.car.engine.RandomEngine
import racingcar.view.InputView

internal fun getWinners(cars: List<Car>, moveCount: Int): List<Car> {
    val maxLastPosition = cars.maxOf { it.positionBy(moveCount) }
    return cars.filter { it.positionBy(moveCount) == maxLastPosition }
}

class GameBoard(minCarCount: Int = 1, minMoveCount: Int = 1) {
    private val inputView = InputView(minCarCount, minMoveCount)
    val cars = inputView.carNames.map { Car(RandomEngine(), it) }
    val moveCount = inputView.moveCount.value
    val winners = getWinners(cars, moveCount)
}
