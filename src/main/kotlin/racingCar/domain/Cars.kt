package racingCar.domain

import racingCar.error.ErrorMessage
import racingCar.view.OutputView

class Cars {

    fun moveCar(cars: List<Car>, tryCount: Int) {
        repeat(tryCount) {
            cars.forEach { it.conditionalMove() }
            OutputView.printCar(cars)
        }
    }

    fun getCars(inputCars: String): List<Car> {
        val split = inputCars.split(",")
        split.forEach { require(it.length <= 5) { ErrorMessage.NAME_TOO_LONG } }

        val carsNames: List<String> = split
        return carsNames.map { Car(it) }
    }

    fun getWinners(carList: List<Car>): String {
        val maxMoveCount = carList.maxByOrNull { it.moveCount }?.moveCount
        val winners: List<Car> = carList.filter { it.moveCount == maxMoveCount }
        return winners.joinToString(", ") { it.name }
    }
}
