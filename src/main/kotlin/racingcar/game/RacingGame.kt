package racingcar.game

import racingcar.car.Car

class RacingGame(private val cars: List<Car>, private val round: Int) {
    private var currentRound = 0

    fun next(): GameResult {
        if (currentRound < round) {
            cars.forEach { it.forward() }
        }

        return GameResult(cars.map { it.position() })
    }
}
