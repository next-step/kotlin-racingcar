package domain.step4.domain.game

import domain.step4.domain.configuration.RacingCarConfiguration
import domain.step4.domain.racingcar.RacingCars
import domain.step4.domain.strategy.MovingStrategy

class RacingCarGame(
    private val racingCarConfiguration: RacingCarConfiguration,
    private val movingStrategy: MovingStrategy,
) {
    fun run(): RacingCarGameRecord {
        val names = racingCarConfiguration.names
        val numberOfAttempts = racingCarConfiguration.numberOfAttempts
        var racingCars = RacingCars.from(names, movingStrategy)
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