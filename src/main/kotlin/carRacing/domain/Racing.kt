package carRacing.domain

import carRacing.serviceimpl.SimpleCarController

class Racing {

    private fun getRaceResult(carCount: Int, tryCount: Int): List<Car> {
        val carList: List<Car> = SimpleCarController().createCars(carCount)

        return start(carList, tryCount)
    }

    private fun start(carList: List<Car>, tryCount: Int): List<Car> {
        var copyCarList = carList.toList()

        for (i in 0 until tryCount) {
            copyCarList = process(carList)
        }

        return copyCarList
    }

    private fun process(carList: List<Car>): List<Car> {
        val copyCarList = carList.toList()

        for (car in copyCarList) {
            car.move()
        }

        return copyCarList
    }
}
