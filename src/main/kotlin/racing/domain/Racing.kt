package racing.domain

data class Racing(
    val cars: Cars,
    private val attemptCount: Int
) {

    fun start(): List<RacingPhaseRecords> {
        return (0 until attemptCount)
            .map { cars.race() }
            .map { RacingPhaseRecords(it) }
    }
}
