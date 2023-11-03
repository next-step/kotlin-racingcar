package carRacing.domain

import carRacing.service.CarFactory
import carRacing.view.CarInfo
import carRacing.view.OutputView

class Racing(private val carFactory: CarFactory) {

    fun getRaceResult(carCount: Int, tryCount: Int): List<Car> {
        val carList: List<Car> = carFactory.createCars(carCount)

        return start(carList, tryCount)
    }

    fun getRaceResult(carInfoList: List<CarInfo>, tryCount: Int): List<Car> {
        val carList: List<Car> = carFactory.createCars(carInfoList)

        return start(carList, tryCount)
    }

    private fun getWinners(carList: List<Car>): List<Car> {
        val maxPosition: Int = carList.maxBy { it.position }.position

        return carList.filter { it.position == maxPosition }
    }

    fun getWinnerNames(carList: List<Car>): List<String> = getWinners(carList).mapIndexed { index, car -> car.name ?: "Unknown $index" }

    private fun start(carList: List<Car>, tryCount: Int): List<Car> {
        var copyCarList = carList.map { it }

        for (i in 0 until tryCount) {
            copyCarList = process(carList)
            OutputView().printMessages(*copyCarList.map { "${it.name} : ${it.getPosition()}" }.toTypedArray())
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
