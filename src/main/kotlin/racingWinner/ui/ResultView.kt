package racingWinner.ui

import racingWinner.vo.Car

object ResultView {
    fun printResult(cars: List<Car>) {
        println("실행 결과")
        cars.forEach {
            println("${it.name} : ${"-".repeat(it.position+1)}")
        }
    }
}
