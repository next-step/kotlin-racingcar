package racingCar.domain

import kotlin.random.Random
import kotlin.random.nextInt

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
