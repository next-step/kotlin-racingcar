package step3.racingcar.car

import step3.racingcar.car.strategy.MoveStrategy

class Driver(
    private val car: Car,
    private val moveStrategy: MoveStrategy
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
