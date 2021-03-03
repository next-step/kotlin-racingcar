package racingcar

class Racing(
    private val trials: Int,
    private val cars: Collection<Car>
) {
    init {
        if (cars.size < 2) {
            throw IllegalArgumentException("At least two cars must be participated. count='${cars.size}'")
        }

        if (trials < 1) {
            throw IllegalArgumentException("The value of trials must be positive value.")
        }
    }

    fun start(): RacingResults {
        val results = (1..trials).map { raceAll() }
        return RacingResults(results)
    }

    private fun raceAll(): RacingTrial {
        return RacingTrial(cars.map { it.race() })
    }
}
