package carRacing.domain

import carRacing.view.OutputView

class Racing(private val carList: List<Car>) {
    fun getRaceResult(tryCount: Int): List<Car> = start(this.carList, tryCount)

    private fun getWinners(carList: List<Car>): List<Car> {
        val maxPosition: Int = carList.maxBy { it.position }.position

        return carList.filter { it.position == maxPosition }
    }

    fun getWinnerNames(carList: List<Car>): List<String> = getWinners(carList).map { it.name }

    private fun start(carList: List<Car>, tryCount: Int): List<Car> {
        var copyCarList = carList.map { it.copy() }

        for (i in 0 until tryCount) {
            copyCarList = process(carList)
            OutputView().printMessages(*copyCarList.map { "${it.name} : ${it.getPosition()}" }.toTypedArray())
        }

        return copyCarList
    }

    private fun process(carList: List<Car>): List<Car> {
        val copyCarList = carList.map { it.copy() }

        for (car in copyCarList) {
            car.move()
        }

        return copyCarList
    }
}
