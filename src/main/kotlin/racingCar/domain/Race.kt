package racingCar.domain

import kotlin.random.Random

private const val RANDOM_NUM_RANGE = 10
private const val REFERENCE_VAL = 4
fun racingRule(): Boolean {
    return Random.nextInt(RANDOM_NUM_RANGE) >= REFERENCE_VAL
}

class Race(private val cars: List<Car>) {
    fun racing() {
        cars.forEach { car ->
            if (racingRule()) {
                car.move()
            }
        }
    }
}
