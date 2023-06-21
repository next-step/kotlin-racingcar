package racingcar.domain

import racingcar.domain.movingstrategy.MovingStrategy

class Cars(private val cars: List<Car>) {

    fun moveAll(movingStrategy: MovingStrategy) {
        cars.forEach { car -> car.move(movingStrategy) }
    }

    fun getPositions(): List<Int> {
        return cars.map(Car::position)
    }

    companion object {
        fun createCountOf(count: Int): Cars {
            val cars = List(count) { Car() }
            return Cars(cars)
        }
    }
}
