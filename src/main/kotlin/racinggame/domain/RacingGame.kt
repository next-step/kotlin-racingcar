package racinggame.domain

import racinggame.domain.car.Car
import racinggame.domain.car.CarFactory
import racinggame.domain.model.RacingGameInput
import racinggame.domain.model.RacingStepResult

class RacingGame(
    private val cars: List<Car>,
    private val numberOfAttempts: Int
) {
    fun start() = List(numberOfAttempts) {
        raceAll()
        getCurrentRacingStepResult()
    }

    private fun getCurrentRacingStepResult() = RacingStepResult(
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
                cars = carsFrom(racingGameInput.names, carFactory),
                numberOfAttempts = racingGameInput.numberOfAttempts
            )
        }

        private fun carsFrom(names: List<String>, carFactory: CarFactory): List<Car> {
            return names.map { name ->
                carFactory.create(name)
            }
        }
    }
}
