package carRacing.ServiceImpl

import carRacing.Domain.Car
import carRacing.Service.CarController

class SimpleCarController : CarController {
    override fun createCars(carCount: Int): List<Car> {
        val carList: MutableList<Car> = mutableListOf()
        for (i in 0 until  carCount) {
            carList.add(Car(RandomMovementController()))
        }

        return carList
    }
}
