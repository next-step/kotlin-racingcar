package carRacing.domain

import carRacing.serviceimpl.SimpleCarController

class Racing {
    fun start(carCount: Int, tryCount: Int): List<Car> {
        var carList: List<Car> = SimpleCarController().createCars(carCount)

        for (i in 0 until tryCount) {
            carList = process(carList)
        }

        return carList
    }

    private fun process(carList: List<Car>): List<Car> {
        val copyCarList = carList.toList()

        for (car in copyCarList) {
            car.move()
        }

        return copyCarList
    }
}
