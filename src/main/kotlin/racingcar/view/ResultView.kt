package racingcar.view

import racingcar.Car

class ResultView {
    fun printCarDistance(cars: List<Car>) {
        cars.forEach {
            println(SPACE.repeat(it.distance))
        }
        println()
    }

    companion object {
        private const val SPACE = "-"
    }
}
