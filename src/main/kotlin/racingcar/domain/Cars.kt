package racingcar.domain

import racingcar.view.Messages
import racingcar.view.OutputView
import java.lang.IllegalArgumentException

class Cars(
    private val cars: List<Car>
) {
    init {
        validateEmptyCars(cars)
        validateDuplicatedCarNames(cars)
    }

    private fun validateEmptyCars(cars: List<Car>) {
        if (cars.isEmpty()) {
            throw IllegalArgumentException(Messages.MESSAGE_CONDITION_CAR_COUNT)
        }
    }

    private fun validateDuplicatedCarNames(cars: List<Car>) {
        val carNames = cars.map { it.carName.name }
        if (carNames.stream().distinct().count().toInt() != carNames.size) {
            throw IllegalArgumentException(Messages.MESSAGE_DUPLICATED_CAR_NAMES)
        }
    }

    fun move() {
        cars.forEach(Car::move)
    }

    fun getPosition() {
        cars.forEach { car ->
            OutputView.printCarNameAndPosition(car.carName.name, car.position)
        }
    }

    fun getWinners(): List<Car> {
        val maxPosition = cars.maxBy { it.position }.position
        return cars.filter { it.position == maxPosition }
    }
}
