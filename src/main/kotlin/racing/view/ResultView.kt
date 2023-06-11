package racing.view

import racing.domain.Car

object ResultView {

    fun printResult() {
        println("실행 결과")
    }

    fun printDistance(position: Int) {
        val distance = "-".repeat(position)
        println(distance)
    }

    fun printNameAndDistance(car: Car) {
        val distance = "-".repeat(car.position)
        val name = car.carName.name
        println("$name : $distance")
    }

    fun printWinnerNames(cars: List<Car>) {
        val winnerNames = cars.joinToString(", ") { it.carName.name!! }
        println("${winnerNames}가 최종 우승했습니다.")
    }

    fun printEnter() {
        println()
    }
}
