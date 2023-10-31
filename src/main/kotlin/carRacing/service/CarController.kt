package carRacing.service

import carRacing.domain.Car

interface CarController {
    fun createCars(carCount: Int): List<Car>
}
