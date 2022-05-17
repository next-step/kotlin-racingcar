package game.racingcar.domain

import game.racingcar.strategy.MoveStrategy

class RacingTrack(private val cars: List<Car>) {
    fun race(numberOfLap: Int, moveStrategy: MoveStrategy): List<Car> {
        repeat(numberOfLap) {
            cars.forEach { it.move(moveStrategy) }
        }
        return cars
    }

    fun getWinners(): List<Car> {
        val maxPosition = cars.maxOf { it.position }
        return cars
            .filter { it.position == maxPosition }
    }
}
