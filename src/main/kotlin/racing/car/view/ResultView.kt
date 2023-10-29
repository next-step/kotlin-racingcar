package racing.car.view

import racing.car.domain.Car

object ResultView {
    fun printResult(carsAfterRace: List<Car>) {
        println("Round Start")
        carsAfterRace.forEach {
            repeat(it.position) { print("-") }
            println()
        }
    }
}
