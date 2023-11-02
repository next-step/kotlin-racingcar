package carRacing.serviceimpl

import carRacing.domain.Car
import carRacing.service.CarFactory

class SimpleCarFactory : CarFactory {
    override fun createCars(carCount: Int): List<Car> = List(carCount) { Car(RandomMovementController()) }

    override fun createCars(carInfoList: List<Map<String, Any>>): List<Car> {
        TODO("Not yet implemented")
    }
}
