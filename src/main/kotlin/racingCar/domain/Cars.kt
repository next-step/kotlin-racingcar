package racingCar.domain

import racingCar.domain.strategy.MoveStrategy
import racingCar.error.ErrorMessage

class Cars(private val moveStrategy: MoveStrategy) {

    fun getCars(inputCars: String): List<Car> {
        val split = inputCars.split(",")
        split.forEach { require(it.length <= LIMIT_CAR_NAME) { ErrorMessage.NAME_TOO_LONG } }

        val carsNames: List<String> = split
        return carsNames.map { Car(name = it, moveStrategy = moveStrategy) }
    }

    fun getWinners(carList: List<Car>): List<Car> {
        val maxMoveCount = carList.maxByOrNull { it.moveCount }?.moveCount
        return carList.filter { it.moveCount == maxMoveCount }
    }

    companion object {
        private const val LIMIT_CAR_NAME = 5
    }
}
