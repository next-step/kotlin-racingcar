package racingcar.racing

import racingcar.racing.car.Car

class Racing(
    private val trials: Int,
    private val cars: Collection<Car>
) {
    init {
        require(cars.size >= 2) {
            "At least two cars must be participated. count='${cars.size}'"
        }
        require(trials >= 1) {
            "The value of trials must be positive value."
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
