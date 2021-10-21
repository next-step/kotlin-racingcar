package domain.step3.domain.game

import domain.step3.domain.configuration.RacingCarConfiguration
import domain.step3.domain.racingcar.RacingCars
import domain.step3.domain.strategy.MovingStrategy

class RacingCarGame(
    private val racingCarConfiguration: RacingCarConfiguration,
    private val movingStrategy: MovingStrategy,
) {
    fun run(): RacingCarGameRecord {
        val numberOfCars = racingCarConfiguration.numberOfCars
        val numberOfAttempts = racingCarConfiguration.numberOfAttempts
        var racingCars = RacingCars.from(numberOfCars, movingStrategy)
        var racingCarGameRecord = RacingCarGameRecord.initialize()

        (START..numberOfAttempts.numberOfAttempts).map {
            racingCars = racingCars.moveForward()
            racingCarGameRecord = racingCarGameRecord.add(racingCars)
        }
        return racingCarGameRecord
    }

    companion object {
        const val START = 1
    }
}
