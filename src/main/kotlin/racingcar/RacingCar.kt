package racingcar

import racingcar.data.MoveHistory

class RacingCar(private val cars: List<Car>, private val tryCount: Int, private val moveHistory: MoveHistory = MoveHistory()) {
    constructor(carNames: String, tryCount: Int) :
        this(carNames.split(",").map { Car(it.trim()) }, tryCount)

    private lateinit var moveStrategy: ForwardStrategy

    fun start(moveStrategy: ForwardStrategy): MoveHistory {
        this.moveStrategy = moveStrategy

        for (i in 0 until tryCount) {
            moveCars()
        }
        return moveHistory
    }

    private fun moveCars() {
        cars.forEach { car ->
            moveHistory.addMove(car.move(moveStrategy.forward()))
        }
    }
}
