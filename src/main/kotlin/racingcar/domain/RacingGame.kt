package racingcar.domain

class RacingGame(
    private val numberOfRaces: Int,
    private val racingCars: RacingCars
) {
    private val racingGameRecords: MutableList<RacingGameRecord> = ArrayList()

    fun play(): List<RacingGameRecord> {
        repeat(numberOfRaces) { phase ->
            val raceRecords = racingCars.race()
            racingGameRecords.add(RacingGameRecord(phase + 1, raceRecords))
        }
        return racingGameRecords.toList()
    }
}

data class RacingGameRecord(
    val phaseOfRace: Int,
    val raceRecord: List<CarRecord>
)
