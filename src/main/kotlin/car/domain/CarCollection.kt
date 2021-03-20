package car.domain

import car.domain.move.RandomMovableStrategy
import car.domain.move.MovableStrategy

class CarCollection(private val cars: List<Car>) : List<Car> by cars {
    val maxPosition
        get() = cars.map { it.position }.max() ?: 0

    constructor(
        carNameCollection: CarNameCollection,
        movableStrategy: MovableStrategy = RandomMovableStrategy()
    ) : this(carNameCollection.map { Car(carName = it, movableStrategy = movableStrategy) })

    fun move(times: Int) {
        repeat(times) {
            moveAllCar()
        }
    }

    private fun moveAllCar() {
        cars.forEach {
            it.move()
        }
    }
}
