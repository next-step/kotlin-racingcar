package racingcar.domain

class RacingCar(private val cars: List<Car>, private val tryCount: Int) {
    constructor(carNames: String, tryCount: Int) :
        this(carNames.split(",").map { Car(it.trim()) }, tryCount)

    private lateinit var moveStrategy: ForwardStrategy

    fun start(moveStrategy: ForwardStrategy): MoveHistory {
        val moveHistory = MoveHistory()
        this.moveStrategy = moveStrategy

        for (i in 0 until tryCount) {
            moveCars(moveHistory)
        }
        return moveHistory
    }

    private fun moveCars(moveHistory: MoveHistory) {
        cars.forEach { car ->
            moveHistory.addMove(car.move(moveStrategy.forward()))
        }
    }
}
