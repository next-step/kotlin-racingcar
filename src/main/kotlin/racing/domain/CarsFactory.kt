package racing.domain

import racing.domain.strategy.MovingStrategy
import racing.domain.strategy.RandomMovingStrategy

object CarsFactory {

    fun createCars(nameList: List<String>, movingStrategy: MovingStrategy = RandomMovingStrategy): List<Car> {
        return nameList.map { Car(it, movingStrategy) }
    }
}
