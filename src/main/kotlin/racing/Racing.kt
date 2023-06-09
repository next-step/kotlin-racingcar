package racing

data class Racing(
    val cars: Cars,
    private val attemptCount: Int
) {

    val racingPhasedRecords: MutableList<RacingPhasedRecord> = mutableListOf()

    fun start() {
        repeat(attemptCount) {
            cars.racing()
            addRacingPhasedRecords(cars)
        }
    }

    private fun addRacingPhasedRecords(cars: Cars) {
        RacingPhasedRecord(cars.cars.map { it.distance }).also {
            racingPhasedRecords.add(it)
        }
    }
}
