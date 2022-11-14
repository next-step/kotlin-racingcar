package racing.domain

import racing.model.Car
import racing.model.Driver

class RacingCarsFactoryImpl : RacingCarsFactory {

    override fun createCars(drivers: List<Driver>): List<Car> =
        drivers.map { Car(driver = it) }
}
