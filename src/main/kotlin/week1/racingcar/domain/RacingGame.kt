package week1.racingcar.domain

import kotlin.random.Random

class RacingGame(
    private val cars: List<Car>,
    private var timesToRace: Int = 0,
) {
    fun driveOneTurn(): List<Car> {
        cars.forEach {
            it.moveOrNotByNum(Random.nextInt(Car.RANDOM_NUM_RANGE))
        }
        timesToRace--
        return cars
    }

    fun isPlaying() = timesToRace > 0

    fun filterWinners(): List<String> {
        val farthestMileage = cars.map { it.currentMileage }
            .maxOf { it }
        return cars.filter { it.isSameMileage(farthestMileage) }
            .map { it.name }
    }
}
