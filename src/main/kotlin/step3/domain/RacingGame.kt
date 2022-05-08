package step3.domain

import step3.model.RacingGameInput
import step3.model.RacingStepStatus

class RacingGame(racingGameInput: RacingGameInput) {
    private val carRacers: List<CarRacer>
    private val numberOfAttempts: Int

    init {
        carRacers = List(racingGameInput.numberOfCars) { CarRacer() }
        numberOfAttempts = racingGameInput.numberOfAttempts
    }

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
}
