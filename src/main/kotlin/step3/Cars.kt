package step3

class Cars(
    private val cars: List<Car>
) {
    fun race() {
        cars.forEach { it.race() }
    }

    fun getCurrentRacingRecords(): List<RacingRecord> {
        return cars.map { RacingRecord(it.name, it.distance) }
    }

    fun findCurrentWinners(): List<String> {
        val furthestDistance = getFurthestDistance()
        return cars
            .filter { it.distance == furthestDistance }
            .map { it.name }
    }

    private fun getFurthestDistance() = cars.map { it.distance }.max()
}
