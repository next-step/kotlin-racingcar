package carRacing.Service

import carRacing.Domain.Car

interface CarController {
    fun createCars(carCount: Int): List<Car>
}
