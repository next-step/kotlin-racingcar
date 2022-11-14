package racingcar.view

import racingcar.domain.Car

object ResultView {
    fun executionResult() {
        println("실행 결과")
    }

    fun presentSituation(name: String, position: Int) {
        println("$name : ${"-".repeat(position)}")
    }

    fun presentWinner(cars: List<Car>) {
        println("${cars.joinToString(", ") { it.name }}가 최종 우승했습니다.")
    }
}
