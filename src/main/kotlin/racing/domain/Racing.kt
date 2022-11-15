package racing.domain

import racing.model.Car

interface Racing {
    fun driveCar(car: Car): Car
}
