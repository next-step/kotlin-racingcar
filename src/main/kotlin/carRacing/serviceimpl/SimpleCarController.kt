package carRacing.serviceimpl

import carRacing.domain.Car
import carRacing.service.CarController

class SimpleCarController : CarController {
    override fun createCars(carCount: Int): List<Car> = List(carCount) { Car(RandomMovementController()) }
}
