package race.domain

class RaceResult(
    val records: List<List<Car>>
) {
    fun findWinners(): List<Car> {
        val lastRecords = records.last()
        val winnerPosition = lastRecords.maxByOrNull { it.position }?.position

        return lastRecords
            .filter { it.position == winnerPosition }
    }
}
