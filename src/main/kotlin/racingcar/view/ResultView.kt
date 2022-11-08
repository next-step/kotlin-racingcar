package racingcar.view

import racingcar.Cars

class ResultView {
    fun printCarDistance(cars: Cars) {
        cars.getCars().forEach {
            println(SPACE.repeat(it.getDistance()))
        }
        println()
    }

    companion object {
        private const val SPACE = "-"
    }
}
