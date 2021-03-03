package study.racingcar.service

import study.racingcar.domain.Car
import study.racingcar.domain.RaceResult
import study.racingcar.util.RacingCarRandomGenerator

class RacingCarGame(
    private val carCount: Int,
    private val tryCount: Int,
    private val cars: List<Car> = (1..carCount).toList().map { Car() },
    private var raceResults: List<RaceResult> = ArrayList()
) {
    fun start() {
        val initialResults = mutableListOf<RaceResult>()
        for (i in 1..this.tryCount) {
            initialResults.add(race(this.cars))
        }

        this.raceResults = initialResults.toList()
    }

    private fun race(cars: List<Car>): RaceResult {
        cars.forEach { it.move(RacingCarRandomGenerator.random()) }
        return RaceResult(cars)
    }

    fun getRaceResults(): List<RaceResult> = this.raceResults
}
