package week1.racingcar.domain

import kotlin.random.Random

class RacingGame(
    private val cars: List<Car>,
    private val timesToRace: Int = 0,
) {
    private var racedTime = 0

    fun driveOneTurn(): List<Car> {
        cars.forEach {
            it.moveOrNotByNum(Random.nextInt(Car.RANDOM_NUM_RANGE))
        }
        racedTime++
        return cars
    }

    fun isPlaying() = racedTime < timesToRace

    fun filterWinners(): List<String> {
        val farthestMileage = cars.map { it.currentMileage() }
            .maxOf { it }
        return cars.filter { it.isSameMileage(farthestMileage) }
            .map { it.name }
    }
}
