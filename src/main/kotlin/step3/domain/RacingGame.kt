package step3.domain

import step3.model.RacingGameInput

class RacingGame(racingGameInput: RacingGameInput) {
    private val carRacers: List<CarRacer>
    private val numberOfAttempts: Int

    init {
        carRacers = List(racingGameInput.numberOfCars) { CarRacer() }
        numberOfAttempts = racingGameInput.numberOfAttempts
    }

    fun start(): List<Int> {
        repeat(numberOfAttempts) {
            raceAll()
        }

        return raceResult()
    }

    private fun raceResult() = carRacers.map { carRacer ->
        carRacer.proceedLevel
    }

    private fun raceAll() {
        carRacers.forEach { carRacer ->
            carRacer.race()
        }
    }
}