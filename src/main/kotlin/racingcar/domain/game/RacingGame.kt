package racingcar.domain.game

import racingcar.domain.car.Car

class RacingGame(private val cars: List<Car>) {
    fun startRound() = cars.forEach { it.move() }
    fun getWinnerCars(): List<Car> {
        val longestDistance = cars.maxBy { it.distance }.distance
        return cars.filter { it.distance == longestDistance }
    }
}
