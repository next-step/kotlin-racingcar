package racing.domain

import racing.model.Car

interface RacingCarsFactory {
    fun createCars(count: Int): List<Car>
}
