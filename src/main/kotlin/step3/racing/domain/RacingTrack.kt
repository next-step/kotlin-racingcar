package step3.racing.domain

import step3.racing.util.RandomGenerator

class RacingTrack(
    racerNames: List<String>,
    private val times: Int,
    private val randomGenerator: RandomGenerator
) {
    val raceHistory: RaceHistory = RaceHistory(times)
    val racers: List<Car> = racerNames.map { Car(it) }

    fun start() = repeat(times) {
        val cars = racers.map { it.run(randomGenerator.getInt(0..9)) }
        raceHistory.push(Round(cars))
    }
}
