package car.domain

import car.domain.move.RandomMovableStrategy
import car.domain.move.MovableStrategy

class CarCollection(private val cars: List<Car>) : List<Car> by cars {
    val winners: List<Car>
        get() = this.filter {
            it.currentPosition == maxPosition
        }

    var maxPosition = findMaxPositionInCars(cars)
        private set

    constructor(
        carNameCollection: CarNameCollection,
        movableStrategy: MovableStrategy = RandomMovableStrategy()
    ) : this(carNameCollection.map { Car(carName = it, movableStrategy = movableStrategy) })

    fun move(times: Int) {
        repeat(times) {
            moveAllCar()
        }
        maxPosition = findMaxPositionInCars(cars)
    }

    private fun moveAllCar() {
        cars.forEach {
            it.move()
        }
    }

    companion object {
        private fun findMaxPositionInCars(cars: List<Car>): Int = cars.map { it.currentPosition }.max() ?: 0
    }
}
