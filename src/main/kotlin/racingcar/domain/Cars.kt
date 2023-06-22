package racingcar.domain

import racingcar.domain.movingstrategy.MovingStrategy

class Cars(private val cars: List<Car>) {

    fun moveAll() {
        cars.forEach { car -> car.move() }
    }

    fun getPositions(): List<Int> {
        return cars.map(Car::position)
    }

    companion object {
        fun createCountOf(count: Int, movingStrategy: MovingStrategy): Cars {
            val cars = List(count) { Car(movingStrategy) }
            return Cars(cars)
        }
    }
}
