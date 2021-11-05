package racingcar.domain

import racingcar.controller.validateWinnersCount

class Cars(carNames: List<String>) {
    private val cars: List<Car>

    init {
        cars = carNames.map { carName -> Car(carName) }
    }

    fun move() {
        cars.forEach { car -> car.move(ATTEMPT_NUMBER_RANGE.random()) }
    }

    fun getCarsNameWithPosition(): Map<String, Int> {
        return cars.associate { it.name to it.position }
    }

    fun getWinners(): List<String> {
        val winnerPosition = cars.maxOf { it.position }
        val winners = cars.filter { it.position == winnerPosition }
        validateWinnersCount(winners)
        return winners.map { it.name }
    }
}
