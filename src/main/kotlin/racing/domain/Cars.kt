package racing.domain

import racing.domain.strategy.MovingStrategy
import racing.domain.strategy.RandomMovingStrategy

object Cars {
    const val NAME_SEPARATOR = ","

    fun splitNameOfCars(nameOfCars: String) = nameOfCars.split(NAME_SEPARATOR)

    fun createCars(nameList: List<String>, movingStrategy: MovingStrategy = RandomMovingStrategy): List<Car> {
        return nameList.map { Car(it, movingStrategy) }
    }
}
