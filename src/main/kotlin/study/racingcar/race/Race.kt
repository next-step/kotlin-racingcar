package study.racingcar.race

import study.racingcar.car.Car

class Race(
    private val cars: List<Car>,
    private val numberOfAttempts: Int
) {
    fun startRace(): RaceSummary {
        val raceResults = (1..numberOfAttempts).map { runSingleAttempt() }
        return RaceSummary(raceResults)
    }
    private fun runSingleAttempt(): RaceResult {
        cars.forEach(Car::move)
        return RaceResult(cars.map { it.getCurrentState() })
    }
}
