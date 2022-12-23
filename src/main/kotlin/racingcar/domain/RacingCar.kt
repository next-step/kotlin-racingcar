package racingcar.domain

import racingcar.data.CarMoves

class RacingCar(private val cars: List<Car>, private val tryCount: Int) {
    constructor(carNames: String, tryCount: Int) :
        this(carNames.split(",").map { Car(it.trim()) }, tryCount)

    fun start(moveStrategy: ForwardStrategy): MoveHistory {
        return MoveHistory(cars.map { car -> moveCars(car, moveStrategy) })
    }

    private fun moveCars(car: Car, moveStrategy: ForwardStrategy): CarMoves {
        return CarMoves(
            car.name,
            (0 until tryCount).map { car.move(moveStrategy.forward()) }
        )
    }
}
