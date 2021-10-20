package racingcar.manager

import racingcar.car.Car

class RacingManager(
    private var carNum: Int,
    private var attempts: Int
) {

    private var cars: List<Car> = listOf()

    init {
        init()
    }

    private fun init() {
        cars = (0 until carNum).map { Car() }
    }

    fun race(show: ((List<Car>) -> Unit)? = null) {
        repeat(attempts) {
            cars.forEach {
                it.movePosition()
            }
            show?.invoke(cars)
        }
    }
}
