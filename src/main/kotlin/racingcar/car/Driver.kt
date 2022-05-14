package racingcar.car

import racingcar.car.strategy.MoveStrategy

class Driver(
    val name: String,
    private val car: Car,
    private val moveStrategy: MoveStrategy,
) {

    fun drive() {
        if (moveStrategy.isMovable()) {
            car.move()
        }
    }

    fun getMoveResult(): Int {
        return car.currentDrivingRecord
    }
}
