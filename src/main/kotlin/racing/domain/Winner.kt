package racing.domain

class Winner {

    companion object {
        fun getWinners(racingPhaseRecords: List<RacingPhaseRecords>): List<String> {
            val lastPhaseRecords = racingPhaseRecords.last()
            val maxDistanceRecords = lastPhaseRecords.records.maxBy { it.distance }
            val winnerRecords = lastPhaseRecords.records
                .filter { it.distance == maxDistanceRecords.distance }

            return winnerRecords.map { it.carName }
        }
    }
}
