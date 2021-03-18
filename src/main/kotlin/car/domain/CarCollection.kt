package car.domain

import car.domain.move.RandomMovableStrategy
import car.domain.move.MovableStrategy

class CarCollection(private val cars: List<Car>) : List<Car> by cars {
    val maxPosition: Int
        get() = cars.map { it.currentPosition }.max() ?: 0

    constructor(
        carNameCollection: CarNameCollection,
        movableStrategy: MovableStrategy = RandomMovableStrategy()
    ) : this(carNameCollection.map { Car(it, movableStrategy) })

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
