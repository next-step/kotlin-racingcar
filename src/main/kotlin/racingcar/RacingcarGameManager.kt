package racingcar

import racingcar.model.Car

class RacingcarGameManager(
    val cars: List<Car>,
    private val carMovementManager: CarMovementManager
) {

    fun doRound() {
        carMovementManager.moveCarsWithCondition(cars)
    }

    fun getWinners(): List<Car> {
        val winnerCar = cars.maxBy {
            it.currentDistance()
        }

        return cars.filter {
            it.currentDistance() == winnerCar.currentDistance()
        }
    }
}
