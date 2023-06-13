package racing.domain

class RacingPhaseRecords(
    val records: List<RacingPhaseRecord>
) {

    fun getWinners(): List<String> {
        val maxDistanceRecords = records.maxBy { it.distance }
        val winnerRecords = records
            .filter { it.distance == maxDistanceRecords.distance }

        return winnerRecords.map { it.carName }
    }
}
