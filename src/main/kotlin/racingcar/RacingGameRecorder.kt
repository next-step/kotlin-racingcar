package racingcar

class RacingGameRecorder {
    private val raceResultRecords = ArrayList<RaceResultRecord>()
    val gameResultRecord: GameResultRecord get() = GameResultRecord(raceResultRecords.toList())

    fun recordRound(cars: List<Car>) {
        val round = raceResultRecords.size + 1
        val positions = cars.map { it.position }

        raceResultRecords.add(RaceResultRecord(round, positions))
    }
}

data class RaceResultRecord(
    val round: Int,
    val positions: List<Int>,
)

data class GameResultRecord(
    val raceResults: List<RaceResultRecord>,
)
