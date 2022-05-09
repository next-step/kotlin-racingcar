package step3.domain

import step3.model.RacingGameInput
import step3.model.RacingStepStatus

class RacingGame(
    private val carRacers: List<CarRacer>,
    private val numberOfAttempts: Int
) {
    fun start() = List(numberOfAttempts) {
        raceAll()
        getCurrentRacingStepStatus()
    }

    private fun getCurrentRacingStepStatus() = RacingStepStatus(
        proceedLevels = carRacers.map { carRacer ->
            carRacer.proceedLevel
        }
    )

    private fun raceAll() {
        carRacers.forEach { carRacer ->
            carRacer.race()
        }
    }

    companion object {
        fun from(racingGameInput: RacingGameInput): RacingGame {
            return RacingGame(
                carRacers = List(racingGameInput.numberOfCars) { CarRacer() },
                racingGameInput.numberOfAttempts
            )
        }
    }
}
