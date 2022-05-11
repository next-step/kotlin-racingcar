package racinggame.domain

import racinggame.domain.car.Car
import racinggame.domain.car.CarFactory
import racinggame.domain.model.RacingGameInput
import racinggame.domain.model.RacingStepStatus

class RacingGame(
    private val cars: List<Car>,
    private val numberOfAttempts: Int
) {
    fun start() = List(numberOfAttempts) {
        raceAll()
        getCurrentRacingStepStatus()
    }

    private fun getCurrentRacingStepStatus() = RacingStepStatus(
        proceedLevels = cars.map { car ->
            car.proceedLevel
        }
    )

    private fun raceAll() {
        cars.forEach { car ->
            car.proceed()
        }
    }

    companion object {
        fun of(racingGameInput: RacingGameInput, carFactory: CarFactory): RacingGame {
            return RacingGame(
                cars = racingGameInput.names.map { carFactory.create() },
                numberOfAttempts = racingGameInput.numberOfAttempts
            )
        }
    }
}
