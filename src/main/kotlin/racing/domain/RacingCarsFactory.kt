package racing.domain

import racing.model.Car
import racing.model.Driver

interface RacingCarsFactory {
    fun createCars(drivers: List<Driver>): List<Car>
}
