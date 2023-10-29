package racingcar.view

import racingcar.model.Cars

object ResultView {

    fun printResult(cars: Cars) {
        println(cars.generateResult())
        println()
    }
}
