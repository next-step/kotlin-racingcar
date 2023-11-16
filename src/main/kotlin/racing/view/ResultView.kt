package racing.view

import racing.domain.Car

object ResultView {
    fun printResult(cars: List<Car>) {
        println("실행 결과")
        cars.forEach {
            println("${it.name} : ${"-".repeat(it.position + 1)}")
        }
        println()
    }

    fun printWinner(cars: List<Car>) {
        val fastestPosition = cars.maxBy { it.position }.position
        val winners = cars.filter { it.isFastestPosition(fastestPosition) }
        println("${winners.joinToString { it.name }}가 최종 우승했습니다.")
    }
}
