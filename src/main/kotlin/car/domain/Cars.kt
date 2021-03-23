package car.domain

import car.domain.history.CarMoveHistories
import car.domain.history.CarMoveHistory
import car.domain.move.RandomMovableStrategy
import car.domain.move.MovableStrategy

class Cars(private val cars: List<Car>) : List<Car> by cars {
    val maxPosition
        get() = cars.map { it.position.value }.max() ?: 0

    val currentMoveHistories
        get() = CarMoveHistories(
            cars.map {
                CarMoveHistory(it.carName, it.position)
            }
        )

    constructor(
        carNames: CarNames,
        movableStrategy: MovableStrategy = RandomMovableStrategy()
    ) : this(carNames.map { Car(carName = it, movableStrategy = movableStrategy) })

    fun move() {
        cars.forEach {
            it.move()
        }
    }
}
