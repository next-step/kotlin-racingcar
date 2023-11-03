package racingcar.domain

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
) {
    val finalRaceResult: RaceResultRecord?
        get() = raceResults.lastOrNull()

    val winners: Winners
        get() {
            val result = finalRaceResult ?: throw IllegalStateException("Never played racing game")

            val maxDistance = result.carPositions
                .maxOfOrNull { it.position }

            val winnersName = result.carPositions
                .filter { it.position == maxDistance }
                .map { it.name }

            return Winners(winnersName)
        }
}
