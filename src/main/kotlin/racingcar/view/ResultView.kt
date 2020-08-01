package racingcar.view

import racingcar.domain.Car
import racingcar.domain.Winner

class ResultView(private val time: Int, private val cars: List<Car>) {
    fun view() {
        println("${time}번째 시도 입니다")
        cars.forEach { println("${it.name} : " + makeResultCarMove(it)) }
        println()
    }

    fun viewWinner() {
        val winner = Winner(cars)
        val winnerList = mutableListOf<String>()
        winner.winnerList.forEach { winnerList.add(it.name) }
        println("${winnerList.joinToString()}가 최종 우승했습니다.")
    }

    private fun makeResultCarMove(car: Car): String = "-".repeat(car.position)
}
