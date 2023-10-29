package racingcar

class RacingGameRecorder {
    private val raceResultRecords = ArrayList<RaceResultRecord>()
    val gameResultRecord: GameResultRecord get() = GameResultRecord(raceResultRecords.toList())

    fun recordRound(cars: List<Car>) {
        val round = raceResultRecords.size + 1
        val positions = cars.map { car ->
            CarPositionRecord(car.name, car.position)
        }

        raceResultRecords.add(RaceResultRecord(round, positions))
    }
}

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
)
