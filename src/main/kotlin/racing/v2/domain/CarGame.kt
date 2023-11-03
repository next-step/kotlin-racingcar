package racing.v2.domain

import racing.v2.console.ResultView
import kotlin.random.Random

class CarGame(val cars: List<Car>, val tryCount: Int) {
    fun start() {
        ResultView.printResultStart()
        
        repeat(tryCount) {
            moveAllCarsOnce()
            ResultView.printCarPosition(cars)
        }

        ResultView.printWinner(findWinners())
    }

    private fun moveAllCarsOnce() {
        cars.forEach {
            it.moveForward(CarDrivingPolicy, Random.nextInt(10))
        }
    }

    private fun findWinners(): List<Car> {
        val maxPosition = cars.maxOf { it.position }
        return cars.filter { it.position == maxPosition }
    }
}
