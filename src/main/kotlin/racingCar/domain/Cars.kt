package racingCar.domain

import racingCar.domain.strategy.MoveStrategy
import racingCar.domain.strategyImpl.RandomStrategy
import racingCar.error.ErrorMessage
import racingCar.view.OutputView

class Cars(private val moveStrategy: MoveStrategy = RandomStrategy()) {

    fun moveCar(cars: List<Car>, tryCount: Int) {
        repeat(tryCount) {
            val movingCars = cars.filter { moveStrategy.isMove() }
            movingCars.forEach { it.move() }
            OutputView.printCar(cars)
        }
    }

    fun getCars(inputCars: String): List<Car> {
        val split = inputCars.split(",")
        split.forEach { require(it.length <= 5) { ErrorMessage.NAME_TOO_LOAD } }

        val carsNames: List<String> = split
        return carsNames.map { Car(it) }
    }
}
