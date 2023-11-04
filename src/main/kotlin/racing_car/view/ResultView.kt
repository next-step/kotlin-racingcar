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

    fun printWinners(winners: List<Car>) {
        val namesOfWinners = winners.joinToString { it.name }
        println("$namesOfWinners (이)가 최종 우승했습니다.")
    }
}
