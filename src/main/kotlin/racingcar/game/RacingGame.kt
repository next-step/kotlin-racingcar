package racingcar.game

import racingcar.car.Car

class RacingGame(private val cars: List<Car>) {
    fun startRound() = cars.forEach { it.move() }
}
