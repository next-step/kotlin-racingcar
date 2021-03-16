package race.ui

import race.domain.Car

object ResultView {
    fun printTitle() {
        println("실행 결과")
    }

    fun printNow(cars: List<Car>) {
        cars.forEach {
            print("${it.name} : ")
            repeat(it.position) {
                print("-")
            }
            println("")
        }
        println()
    }

    fun printWinner(winners: List<Car>) {
        val winnerNames = winners.joinToString(", ") { it.name }
        println("${winnerNames}가 최종 우승했습니다.")
    }
}
