package racingcar.domain

import racingcar.common.RandomCommandGenerator

class RacingGame(
    private val numberOfRaces: Int,
    private val racingCars: RacingCars
) {
    private val racingGameRecords: MutableList<RacingGameRecord> = ArrayList()

    fun play(): List<RacingGameRecord> {
        repeat(numberOfRaces) { phase ->
            val movementCommands = generateMovementCommands()
            val raceRecords = racingCars.race(movementCommands)
            racingGameRecords.add(RacingGameRecord(phase + 1, raceRecords))
        }
        return racingGameRecords.toList()
    }

    private fun generateMovementCommands(): List<MovementCommand> {
        return List(racingCars.size) {
            MovementCommand.of(RandomCommandGenerator.nextCommand())
        }
    }
}

data class RacingGameRecord(
    val phaseOfRace: Int,
    val raceRecord: List<CarRecord>
)
