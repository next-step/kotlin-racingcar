package carRacing.domain

import carRacing.serviceimpl.SimpleCarController
import carRacing.view.OutputView

class Racing {

    fun getRaceResult(carCount: Int, tryCount: Int): List<Car> {
        val carList: List<Car> = SimpleCarController().createCars(carCount)

        return start(carList, tryCount)
    }

    fun getWinners(carList: List<Car>): List<Car> {
        val maxPosition: Int = carList.maxBy { it.position }.position

        return carList.filter { it.position == maxPosition }
    }

    private fun start(carList: List<Car>, tryCount: Int): List<Car> {
        var copyCarList = carList.toList()

        for (i in 0 until tryCount) {
            copyCarList = process(carList)
            OutputView().printMessages(*copyCarList.map { it.getPosition() }.toTypedArray())
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
