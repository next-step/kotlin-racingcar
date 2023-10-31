package racingcar.component

import racingcar.model.Car
import racingcar.model.RacingcarGameInput

class RacingcarGameContext(
    val cars: List<Car>,
    private val carMovementManager: CarMovementManager = CarMovementManager()
) {

    fun doRound() {
        carMovementManager.moveCarsWithCondition(cars)
    }

    fun getWinners(): List<Car> {
        val winnerCar = cars.maxBy {
            it.getDistance()
        }

        return cars.filter {
            it.getDistance() == winnerCar.getDistance()
        }
    }

    companion object {
        fun create(input: RacingcarGameInput): RacingcarGameContext {
            val carNumber = input.carNumber

            return RacingcarGameContext(
                cars = Car.create(carNumber)
            )
        }
    }
}
