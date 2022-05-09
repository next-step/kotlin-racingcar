package racingcar.domain

class RacingGame(
    private val numberOfRaces: Int,
    private val racingCars: RacingCars
) {

    fun play(): GameRecord {
        val raceRecords = ArrayList<RaceRecord>()

        repeat(numberOfRaces) {
            raceRecords.add(racingCars.race())
        }

        return GameRecord(raceRecords.toList())
    }
}

data class GameRecord(
    val raceRecords: List<RaceRecord>
)
