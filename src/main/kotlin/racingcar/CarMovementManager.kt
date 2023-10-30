package racingcar

import racingcar.model.Car
import kotlin.random.Random.Default.nextInt

class CarMovementManager(
    private val condition: () -> Boolean = DEFAULT_MOVEMENT_CONDITION
) {
    fun moveCarsWithCondition(cars: List<Car>) {
        cars
            .filter { condition() }
            .forEach {
                it.move()
            }
    }

    companion object {
        val DEFAULT_MOVEMENT_CONDITION = { nextInt(0, 10) >= 4 }
    }
}
