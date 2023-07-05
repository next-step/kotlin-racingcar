package racingcar

import kotlin.random.Random

class RacingCars private constructor(private val cars: List<RacingCar>) {
    fun getCars(): List<RacingCar> {
        return cars
    }

    fun runCars() {
        cars.forEach { it.tryMove(Random.nextInt(RacingCar.MAXIMUM_POWER_NUMBER + 1)) }
    }

    companion object {
        fun of(racingCars: List<RacingCar>): RacingCars {
            return RacingCars(racingCars)
        }
    }
}
