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
        val trials = (1..trials).map { raceAll(it) }
        return RacingResults(trials)
    }

    private fun raceAll(order: Int): RacingTrial {
        cars.forEach { it.race() }
        return RacingTrial.of(order, cars)
    }
}
