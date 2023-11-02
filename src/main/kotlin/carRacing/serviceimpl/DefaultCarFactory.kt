package carRacing.serviceimpl

import carRacing.domain.Car
import carRacing.service.CarFactory
import carRacing.service.MovementController

open class DefaultCarFactory : CarFactory {
    override fun createCars(carCount: Int): List<Car> = throw NotImplementedError()

    override fun createCars(carInfoList: List<Map<String, Any>>): List<Car> {
        val carList = mutableListOf<Car>()
        for (carInfo in carInfoList) {
            carList.add(Car(carInfo["movementController"] as MovementController))
        }

        return carList
    }
}
