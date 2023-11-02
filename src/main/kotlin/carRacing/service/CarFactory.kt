package carRacing.service

import carRacing.domain.Car
import carRacing.view.CarInfo

interface CarFactory {
    fun createCars(carCount: Int): List<Car>

    fun createCars(carInfoList: List<CarInfo>): List<Car>
}
