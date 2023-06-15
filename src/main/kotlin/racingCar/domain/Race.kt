package racingCar.domain

import kotlin.random.Random

private const val RANDOM_NUM_RANGE = 10
private const val REFERENCE_VAL = 4
fun racingRule(): Boolean {
    return Random.nextInt(0..9) >= REFERENCE_VAL
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
