package racingcar.game

import racingcar.car.Car

class RacingGame(private val cars: List<Car>, private val round: Int) {
    private var currentRound = 0

    init {
        require(round > 0) { "round 는 1 이상이어야 합니다" }
        require(cars.isNotEmpty()) { "자동차는 1대 이상이어야 합니다" }
    }

    fun next(): GameResult {
        if (hasNext()) {
            cars.forEach { it.forward() }
            currentRound++
        }

        return GameResult(cars.map { it.position() })
    }

    fun hasNext(): Boolean = currentRound < round
}
