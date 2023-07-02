package racingcar

import kotlin.random.Random

class RacingCars(val cars: MutableList<RacingCar> = mutableListOf()) {

    fun addCars(racingCars: List<RacingCar>) {
        cars.addAll(racingCars)
    }

    fun runCars() {
        cars.forEach { it.tryMove(Random.nextInt(RacingCar.MAXIMUM_POWER_NUMBER + 1)) }
    }
}
