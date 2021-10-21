package domain.step4.domain.game

import domain.step4.domain.configuration.RacingCarConfiguration
import domain.step4.domain.racingcar.RacingCars
import domain.step4.domain.strategy.MovingStrategy

class RacingCarGame(
    private val racingCarConfiguration: RacingCarConfiguration,
    private val movingStrategy: MovingStrategy,
) {
    fun run(): RacingCarGameRecord {
        val numberOfAttempts = racingCarConfiguration.numberOfAttempts
        val numberOfAttemptsInt = numberOfAttempts.numberOfAttempts
        var racingCars = RacingCars.from(racingCarConfiguration.names, movingStrategy)
        var racingCarGameRecord = RacingCarGameRecord.initialize()

        (START..numberOfAttemptsInt).map {
            racingCars = racingCars.moveForward()
            racingCarGameRecord = racingCarGameRecord.add(racingCars)
        }
        return racingCarGameRecord
    }

    companion object {
        private const val START = 1
    }
}