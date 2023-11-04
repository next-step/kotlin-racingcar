package racing_car.view

import racing_car.domain.Car

object ResultView {

    fun printResultTitle() {
        println("\n실행 결과")
    }

    fun printPosition(cars: List<Car>) {
        cars.forEach {
            val name = it.name
            val positionBar = "-".repeat(it.position)
            println("$name : $positionBar")
        }
        println()
    }
}
