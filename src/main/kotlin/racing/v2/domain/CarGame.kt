package racing.v2.domain

import racing.v2.console.ResultView
import kotlin.random.Random

class CarGame(val cars: List<Car>, val tryCount: Int) {
    fun start() {
        repeat(tryCount) {
            moveAllCarsOnce()
            ResultView.printCarPosition(cars)
        }
    }

    private fun moveAllCarsOnce() {
        cars.forEach {
            it.moveForward(CarDrivingPolicy, Random.nextInt(10))
        }
    }
}
