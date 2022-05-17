package racingcar.game

import racingcar.car.Car

class RacingGame(private val cars: List<Car>, private val round: Int) {
    private var currentRound = 0

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
