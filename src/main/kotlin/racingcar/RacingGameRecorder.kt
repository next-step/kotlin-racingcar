package racingcar

class RacingGameRecorder {
    private val raceResultRecords = ArrayList<RaceResultRecord>()
    private var winners: Winners? = null

    val gameResultRecord: GameResultRecord get() = GameResultRecord(raceResultRecords.toList(), winners)

    fun recordRound(cars: List<Car>) {
        val round = raceResultRecords.size + 1
        val positions = cars.map { car ->
            CarPositionRecord(car.name, car.position)
        }

        raceResultRecords.add(RaceResultRecord(round, positions))
    }

    fun recordWinners(names: List<String>) {
        winners = Winners(names)
    }
}

data class Winners(
    val names: List<String>,
)

data class CarPositionRecord(
    val name: String,
    val position: Int,
)

data class RaceResultRecord(
    val round: Int,
    val carPositions: List<CarPositionRecord>,
)

data class GameResultRecord(
    val raceResults: List<RaceResultRecord>,
    val winners: Winners?,
) {
    val finalRaceResult: RaceResultRecord?
        get() = raceResults.lastOrNull()
}
