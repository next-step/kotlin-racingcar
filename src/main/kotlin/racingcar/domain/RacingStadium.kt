package racingcar.domain

import racingcar.domain.RacingResult.RacingHistory

class RacingStadium(
    private val racingPlayers: RacingPlayers,
    private val racingRule: RacingRule
) {

    fun gameStart(numberOfTrials: Int): RacingResult {
        val result = mutableListOf<List<RacingHistory>>()
        val cars: List<Car> = racingPlayers.names.map(::Car)
        repeat(numberOfTrials) {
            moving(cars)
            result.add(racingResult(cars))
        }
        return RacingResult(result)
    }

    private fun moving(cars: List<Car>) {
        cars.filter { racingRule.canMoveForward() }
            .forEach(Car::moveForward)
    }

    private fun racingResult(cars: List<Car>): List<RacingHistory> = cars.map { RacingHistory(it.name, it.position) }
}
