package racingcar.domain

import kotlin.random.Random

object CarMovementRule {
    private const val RANDOM_UPPER_BOUND = 10

    fun apply(cars: List<Car>) {
        cars.forEach { car ->
            car.moveOrStay(Random.nextInt(RANDOM_UPPER_BOUND))
        }
    }
}
