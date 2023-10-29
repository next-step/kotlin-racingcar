package racingcar

import racingcar.model.Car
import kotlin.random.Random.Default.nextInt

class CarMovementManager(
    private val condition: () -> Boolean = { nextInt(0, 10) >= 4 }
) {
    fun moveCarsWithCondition(cars: List<Car>) {
        cars
            .filter { condition() }
            .forEach {
                it.move()
            }
    }
}
