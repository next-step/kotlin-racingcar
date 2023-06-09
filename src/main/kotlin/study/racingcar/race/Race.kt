package study.racingcar.race

import study.racingcar.car.Car

class Race(
    private val cars: List<Car>,
    private val numberOfAttempts: Int
) {
    fun startRace(): RaceSummary {
        val raceResults = mutableListOf<RaceResult>()

        repeat(numberOfAttempts) {
            raceResults.add(runSingleAttempt())
        }

        return RaceSummary(raceResults)
    }
    private fun runSingleAttempt(): RaceResult {
        cars.forEach { car ->
            car.move()
        }
        return RaceResult(cars.map { it.getCurrentState() })
    }
}
