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

    private fun findMaxPosition(): Int? = cars.maxByOrNull { it.position }?.position

    fun findWinners(): List<Car> {
        return cars.filter { it.position == findMaxPosition() }
    }

    fun getPositions(): List<Int> = cars.map { it.position }
}
