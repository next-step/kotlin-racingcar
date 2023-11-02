package carRacing.domain

import carRacing.service.CarFactory
import carRacing.view.OutputView

class Racing(private val carFactory: CarFactory) {

    fun getRaceResult(carCount: Int, tryCount: Int): List<Car> {
        val carList: List<Car> = carFactory.createCars(carCount)

        return start(carList, tryCount)
    }

    // 사용하지는 않으나 미리 구현, 테스트는 X
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
