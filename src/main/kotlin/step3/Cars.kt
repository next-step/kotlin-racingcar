package step3

class Cars(
    private val cars: List<Car>
) {
    fun race() {
        cars.forEach { it.race() }
    }

    fun getCurrentRacingRecord(): RacingRecord {
        val recordMap = mutableMapOf<String, Int>()
        cars.forEach { recordMap[it.name] = it.distance }
        return RacingRecord(recordMap)
    }

    fun findCurrentWinners(): List<String> {
        val furthestDistance = getFurthestDistance()
        return cars
            .filter { it.distance == furthestDistance }
            .map { it.name }
    }

    private fun getFurthestDistance() = cars.map { it.distance }.max()
}
