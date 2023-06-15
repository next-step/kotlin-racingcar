package racing.domain

data class Racing(
    val cars: Cars
) {

    fun start(attemptCount: Int): List<RacingPhaseRecords> {
        return (0 until attemptCount)
            .map { cars.race() }
    }

    companion object {
        fun of(carNames: List<String>): Racing {
            val cars = carNames.map {
                Car(name = it, forwardCondition = RandomNumberForwardCondition())
            }

            return Racing(Cars(cars))
        }
    }
}
