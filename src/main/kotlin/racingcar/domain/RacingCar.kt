package racingcar.domain

class RacingCar(private val cars: List<Car>, private val tryCount: Int) {
    constructor(carNames: String, tryCount: Int) :
        this(carNames.split(",").map { Car(it.trim()) }, tryCount)

    fun start(moveStrategy: ForwardStrategy): MoveHistory {
        val moveHistory = MoveHistory()

        cars.forEach { car ->
            val moveInfos = moveCars(car, moveStrategy)
            moveHistory.addMoveInfos(moveInfos)
        }
        return moveHistory
    }

    private fun moveCars(car: Car, moveStrategy: ForwardStrategy): List<MoveInfo> {
        return (0 until tryCount).map {
            car.move(moveStrategy.forward())
        }
    }
}
