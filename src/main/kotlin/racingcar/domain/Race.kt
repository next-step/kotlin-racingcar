package racingcar.domain

import racingcar.service.CarMovingRule

class Race(
    val round: Int
) {

    private val movingRule = CarMovingRule()
    fun run(cars: List<Car>) = cars.moveCars()

    fun findWinnersName(cars: List<Car>) = cars.filter { it.route == findHighRoute(cars) }.map { it.name }

    private fun findHighRoute(cars: List<Car>) = cars.maxOf { it.route }

    private fun List<Car>.moveCars(): List<Car> {
        this.forEach { moveCar(it) }
        return this
    }

    private fun moveCar(car: Car) {
        if (movingRule.isMoving()) car.move()
    }
}
