package race.ui

import race.domain.Car

class ResultView {

    companion object {
        fun printTitle() {
            println("실행 결과")
        }

        fun printNow(cars: List<Car>) {
            cars.forEach {
                print("${it.name} : ")
                IntRange(1, it.position).forEach { _ -> print("-") }
                println("")
            }
        }

        fun printWinner(winners: List<Car>) {
            val winnerNames = winners.joinToString(", ") { it.name }
            println("${winnerNames}가 최종 우승했습니다.")
        }

    }
}
