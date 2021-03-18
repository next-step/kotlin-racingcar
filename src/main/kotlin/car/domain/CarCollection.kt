package car.domain

import car.domain.move.RandomMovableStrategy
import car.domain.move.MovableStrategy

class CarCollection(val cars: List<Car>) {
    val maxPosition: Int
        get() = cars.map { it.currentPosition }.max() ?: 0

    constructor(
        carNameCollection: CarNameCollection,
        movableStrategy: MovableStrategy = RandomMovableStrategy()
    ) : this(carNameCollection.names.map { Car(it, movableStrategy) })

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
