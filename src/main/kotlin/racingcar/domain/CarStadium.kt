package racingcar.domain

import racingcar.domain.RacingHistories.*

class CarStadium(
    nameOfCars: String,
    private val numberOfTrials: Int,
    private val carMove: CarMove
) {

    private val cars: List<Car> = nameOfCars.split(",").map(::Car)

    fun gameStart() = RacingHistories().apply {
        repeat(numberOfTrials) {
            moving()
            this.addRacingHistories(racingResult())
        }
    }

    private fun moving() {
        cars.filter { carMove.canMoveForward() }
            .forEach(Car::moveForward)
    }

    private fun racingResult() = cars.map { RacingHistory(it.name, it.moveForwardCount) }
}
