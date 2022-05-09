package car.domain

import car.ui.NumberOfCar
import car.ui.TryCount

class CarRacing {

    fun race(numberOfCar: NumberOfCar, tryCount: TryCount): Cars {
        val cars = Cars(numberOfCar)
        (0..tryCount.value).forEach {
            cars.move(RandomMovingStrategy())
        }
        return cars
    }
}
