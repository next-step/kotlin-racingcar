package racing.domain

import racing.model.Car
import racing.model.CarName

interface RacingCarsFactory {
    fun createCars(carNames: List<CarName>): List<Car>
}
