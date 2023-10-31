package racingcar.domain

import racingcar.domain.RacingResult.*

class CarStadium(
    nameOfCars: List<String>,
    private val numberOfTrials: Int,
    private val carMove: CarMove
) {

    private val cars: List<Car> = nameOfCars.map(::Car)

    fun gameStart() = RacingResult().apply {
        repeat(numberOfTrials) {
            moving()
            this.addRacingHistories(racingResult())
        }
    }

    private fun moving() {
        cars.filter { carMove.canMoveForward() }
            .forEach(Car::moveForward)
    }

    private fun racingResult(): List<RacingHistory> = cars.map { RacingHistory(it.name, it.position) }
}
