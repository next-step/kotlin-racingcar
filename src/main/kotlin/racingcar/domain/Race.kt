package racingcar.domain

import kotlin.random.Random

const val RANDOM_MIN_NUM = 0
const val RANDOM_MAX_NUM = 9
const val RANDOM_CONDITION_NUM = 4

class Race(
    val round: Int
) {
    fun run(cars: List<Car>) = cars.moveCars()

    private fun List<Car>.moveCars(): List<Car> {
        this.forEach { moveCar(it) }
        return this
    }

    private fun moveCar(car: Car) {
        if (movingRule()) car.move()
    }

    private fun movingRule() = Random.nextInt(RANDOM_MIN_NUM, RANDOM_MAX_NUM) >= RANDOM_CONDITION_NUM
}
