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
        var resultCarList: List<Car> = listOf()
        repeat(tryCount) {
            resultCarList = process(carList)
            OutputView().printMessages(*carList.map { "${it.name} : ${it.getPosition()}" }.toTypedArray())
        }

        return resultCarList
    }

    private fun process(carList: List<Car>): List<Car> {
        carList.forEach(Car::move)

        return carList
    }
}
