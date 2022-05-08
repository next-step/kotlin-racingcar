package racingcar.domain

import racingcar.common.RandomCommandGenerator

class RacingGame(
    private val numberOfPhases: Int,
    private val racingCars: RacingCars
) {
    private val raceRecords: MutableList<RacingRecord> = ArrayList()

    fun proceed(): List<RacingRecord> {
        repeat(numberOfPhases) { phase ->
            val movementCommands = generateMovementCommands()
            val phaseResult = racingCars.execute(movementCommands)
            raceRecords.add(RacingRecord(phase + 1, phaseResult))
        }
        return raceRecords.toList()
    }

    private fun generateMovementCommands(): List<MovementCommand> {
        return IntRange(1, racingCars.size).map {
            val command = RandomCommandGenerator.nextCommand()
            MovementCommand.of(command)
        }
    }
}

data class RacingRecord(
    val phase: Int,
    val carStates: List<CarState>
)
