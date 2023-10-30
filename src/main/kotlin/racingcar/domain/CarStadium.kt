package racingcar.domain

import racingcar.domain.RacingHistories.*

class CarStadium(
    numberOfCars: Int,
    private val numberOfTrials: Int,
    private val carMove: CarMove
) {

    private val cars: List<Car> = List(numberOfCars) { Car(it) }

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

    private fun racingResult() = cars.map { RacingHistory(it.moveForwardCount) }
}
