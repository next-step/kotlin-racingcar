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
        var current = cars

        while (currentRound < round) {
            currentRound++
            current = current.map { it.forward() }
            results.add(GameResult(current))
        }

        return results
    }
}
