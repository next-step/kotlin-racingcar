package racingcar.component

import kotlin.random.Random.Default.nextInt

class CarMovementManager(
    private val condition: () -> Boolean = DEFAULT_MOVEMENT_CONDITION
) {
    fun moveCarsWithCondition(cars: Cars) {
        cars.getCars()
            .filter { condition() }
            .forEach {
                it.move()
            }
    }

    companion object {
        val DEFAULT_MOVEMENT_CONDITION = { nextInt(0, 10) >= 4 }
    }
}
