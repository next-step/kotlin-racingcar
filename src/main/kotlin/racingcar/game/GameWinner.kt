package racingcar.game

import racingcar.car.Car

object GameWinner {
    fun of(gameResult: List<GameResult>): List<Car> {
        val last = gameResult.last().cars
        val maximum = last.maxOfOrNull { it.position().value } ?: 0

        return last.filter { it.position().value == maximum }
    }
}
