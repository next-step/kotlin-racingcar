package racingcar.domain

import racingcar.domain.RacingResult.*

class RacingStadium(
    nameOfCars: List<String>,
    private val numberOfTrials: Int,
    private val racingRule: RacingRule
) {

    private val cars: List<Car> = nameOfCars.map(::Car)

    fun gameStart(): RacingResult = RacingResult().apply {
        repeat(numberOfTrials) {
            moving()
            this.addRacingHistories(racingResult())
        }
    }

    private fun moving() {
        cars.filter { racingRule.canMoveForward() }
            .forEach(Car::moveForward)
    }

    private fun racingResult(): List<RacingHistory> = cars.map { RacingHistory(it.name, it.position) }
}
