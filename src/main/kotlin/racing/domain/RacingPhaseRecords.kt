package racing.domain

class RacingPhaseRecords(
    val records: List<RacingPhaseRecord>
) {

    private val maxDistanceRecords = records.maxBy { it.distance }

    fun getWinners(): List<String> {
        val winnerRecords = records
            .filter { it.distance == maxDistanceRecords.distance }

        return winnerRecords.map { it.carName }
    }
}
