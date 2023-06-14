package racingcar.domain

import racingcar.view.Messages

class Cars(
    private val cars: List<Car>
) {
    init {
        validateEmptyCars(cars)
        validateDuplicatedCarNames(cars)
    }

    private fun validateEmptyCars(cars: List<Car>) {
        require(cars.isNotEmpty()) {
            Messages.MESSAGE_CONDITION_CAR_COUNT
        }
    }

    private fun validateDuplicatedCarNames(cars: List<Car>) {
        val carNames = cars.map { it.carName.name }
        require(carNames.stream().distinct().count().toInt() == carNames.size) {
            Messages.MESSAGE_DUPLICATED_CAR_NAMES
        }
    }

    fun move() {
        cars.forEach(Car::move)
    }

    fun getCars(): List<Car> = cars

    fun getWinners(): List<Car> {
        val maxPosition = cars.maxBy { it.position }.position
        return cars.filter { it.position == maxPosition }
    }
}
