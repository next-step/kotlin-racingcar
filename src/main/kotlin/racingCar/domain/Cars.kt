package racingCar.domain

import racingCar.domain.strategy.MoveStrategy
import racingCar.error.ErrorMessage
import racingCar.view.OutputView

class Cars(private val moveStrategy: MoveStrategy) {

    fun moveCar(cars: List<Car>, tryCount: Int) {
        repeat(tryCount) {
            cars.forEach { it.moveByStrategy() }
            OutputView.printCar(cars)
        }
    }

    fun getCars(inputCars: String): List<Car> {
        val split = inputCars.split(",")
        split.forEach { require(it.length <= LIMIT_CAR_NAME) { ErrorMessage.NAME_TOO_LONG } }

        val carsNames: List<String> = split
        return carsNames.map { Car(name = it, moveStrategy = moveStrategy) }
    }

    fun getWinners(carList: List<Car>): String {
        val maxMoveCount = carList.maxByOrNull { it.moveCount }?.moveCount
        val winners: List<Car> = carList.filter { it.moveCount == maxMoveCount }
        return winners.joinToString(", ") { it.name }
    }

    companion object {
        private const val LIMIT_CAR_NAME = 5
    }
}
