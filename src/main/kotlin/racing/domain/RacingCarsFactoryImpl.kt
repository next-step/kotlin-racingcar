package racing.domain

import racing.model.Car
import racing.model.CarName

class RacingCarsFactoryImpl : RacingCarsFactory {

    override fun createCars(carNames: List<CarName>): List<Car> =
        carNames.map { Car(carName = it) }
}
