package racingCar.domain

import racingCar.domain.strategy.MoveStrategy
import racingCar.domain.strategyImpl.RandomStrategy
import racingCar.error.ErrorMessage

class Cars(private val moveStrategy: MoveStrategy = RandomStrategy(), carList: List<Car> = emptyList()) {

    var carList: List<Car> = carList
        private set

    var carHisList: MutableList<Car> = mutableListOf()
        private set

    fun initCars(inputCars: String, delimiter: String = COMMA) {
        val split = inputCars.split(delimiter)
        split.forEach { require(it.length <= LIMIT_CAR_NAME) { ErrorMessage.NAME_TOO_LONG } }

        val carsNames: List<String> = split
        carList = carsNames.map { Car(name = it, moveStrategy = moveStrategy) }
    }

    fun carsMove(tryCount: Int) {
        repeat(tryCount) {
            carList.forEach {
                it.move()
                saveCarLog(it.copy())
            }
        }
    }

    private fun saveCarLog(car: Car) {
        carHisList.add(car)
    }

    fun getWinners(): List<Car> {
        val maxMoveCount = carList.maxByOrNull { it.moveCount }?.moveCount
        return carList.filter { it.moveCount == maxMoveCount }
    }

    companion object {
        private const val LIMIT_CAR_NAME = 5
        private const val COMMA = ","
    }
}
