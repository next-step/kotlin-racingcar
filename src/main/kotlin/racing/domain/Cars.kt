package racing.domain

import racing.domain.strategy.MovingStrategy
import racing.domain.strategy.RandomMovingStrategy

object Cars {
    const val NAME_SEPARATOR = ","

    fun createCars(nameOfCars: String, movingStrategy: MovingStrategy = RandomMovingStrategy): List<Car> {
        val nameList = nameOfCars.split(NAME_SEPARATOR)
        val cars = mutableListOf<Car>()
        nameList.onEach {
            cars.add(Car(it, movingStrategy))
        }

        return cars.toMutableList()
    }

    fun getWinnerCars(cars: List<Car>): List<Car> {
        val maxPosition = cars.maxOf { car -> car.position }
        return cars.filter { car -> car.position == maxPosition }
    }
}
