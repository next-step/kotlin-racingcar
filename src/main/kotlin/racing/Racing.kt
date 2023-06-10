package racing

data class Racing(
    val cars: Cars,
    private val attemptCount: Int
) {

    fun start() = (0 until attemptCount).map {
        cars.race().map { car ->
            car.getDistance()
        }
    }.map { RacingPhasedRecord(it) }
}
