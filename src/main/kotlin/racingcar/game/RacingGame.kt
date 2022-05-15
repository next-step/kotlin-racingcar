package racingcar.game

import racingcar.car.Car

class RacingGame(private val cars: List<Car>, private val round: Int) {
    private var currentRound = 0

    init {
        require(round > 0) { "round 는 1 이상이어야 합니다" }
        require(cars.isNotEmpty()) { "자동차는 1대 이상이어야 합니다" }
    }

    fun getResults(): List<GameResult> {
        val results = mutableListOf<GameResult>()

        while (hasNext()) {
            results.add(next())
        }

        return results
    }

    private fun next(): GameResult {
        cars.forEach { it.forward() }
        currentRound++

        return GameResult(cars.map { it.position() })
    }

    private fun hasNext(): Boolean = currentRound < round
}
