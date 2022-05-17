package game.racingcar.domain

import game.racingcar.strategy.MoveStrategy

class RacingTrack(private val cars: List<Car>) {
    fun race(numberOfLap: Int, moveStrategy: MoveStrategy): List<Car> {
        for (i in 0 until numberOfLap) {
            cars.forEach { it.move(moveStrategy) }
        }
        return cars
    }

    fun getWinners(): List<Car> {
        val maxPosition = cars.maxByOrNull { it.position }!!.position
        return cars
            .sortedByDescending { it.position }
            .takeWhile { it.position == maxPosition }
    }
}
