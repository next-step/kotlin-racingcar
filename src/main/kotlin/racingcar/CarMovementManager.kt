package racingcar

import racingcar.model.Car

class CarMovementManager(
    private val condition: () -> Boolean
) {
    fun moveCarsWithCondition(cars: List<Car>) {
        cars
            .filter { condition() }
            .forEach {
                it.move()
            }
    }
}
