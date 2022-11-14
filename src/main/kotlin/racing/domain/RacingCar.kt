package racing.domain

import racing.model.Car

interface RacingCar {
    fun driveCar(car: Car): Car
}
