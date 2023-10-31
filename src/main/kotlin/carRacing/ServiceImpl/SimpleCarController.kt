package carRacing.ServiceImpl

import carRacing.Domain.Car
import carRacing.Service.CarController

class SimpleCarController : CarController {
    override fun createCars(carCount: Int): List<Car> = List(carCount) { Car(RandomMovementController()) }
}
