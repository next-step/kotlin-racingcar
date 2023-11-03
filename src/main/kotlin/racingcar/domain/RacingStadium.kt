package racingcar.domain

import racingcar.domain.RacingResult.RacingHistory

class RacingStadium(
    private val racingPlayers: RacingPlayers,
    private val racingRule: RacingRule
) {

    private val cars: List<Car> = racingPlayers.names.map(::Car)

    fun gameStart(): RacingResult {
        val result = mutableListOf<List<RacingHistory>>()
        repeat(racingPlayers.numberOfTrials) {
            moving()
            result.add(racingResult())
        }
        return RacingResult(result)
    }

    private fun moving() {
        cars.filter { racingRule.canMoveForward() }
            .forEach(Car::moveForward)
    }

    private fun racingResult(): List<RacingHistory> = cars.map { RacingHistory(it.name, it.position) }
}
