package racingcar.manager

import racingcar.car.Car

class RacingManager(
    private var cars: List<Car>
) {

    fun race(show: ((List<Car>) -> Unit)? = null) {
        cars.forEach {
            it.movePosition()
        }
        show?.invoke(cars)
    }

    private fun findMaxPosition(): Int? = cars.maxByOrNull { it.getPosition() }?.getPosition()

    fun findWinners(): List<Car> {
        return cars.filter { it.getPosition() == findMaxPosition() }
    }

    fun getPositions(): List<Int> = cars.map { it.getPosition() }
}
