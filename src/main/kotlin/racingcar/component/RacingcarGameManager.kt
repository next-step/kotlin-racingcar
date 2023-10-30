package racingcar.component

import racingcar.model.Car
import racingcar.model.RacingcarGameInput

class RacingcarGameManager(
    val cars: List<Car>,
    private val carMovementManager: CarMovementManager = CarMovementManager()
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

    companion object {
        fun create(input: RacingcarGameInput): RacingcarGameManager {
            val carNumber = input.carNumber

            return RacingcarGameManager(
                cars = Car.create(carNumber)
            )
        }
    }
}
