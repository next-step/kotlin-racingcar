package racing.ui

import racing.Car

object ResultView {
    fun printResult(cars: List<Car>) {
        println("실행 결과")
        cars.forEach {
            println("${it.name} : ${"-".repeat(it.position + 1)}")
        }
        println()
    }
}
