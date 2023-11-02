package racing.v2.console

import racing.v2.domain.Car

object ResultView {
    const val RESULT_PRINT_START_MESSAGE = "실행 결과"

    fun printResultStart() {
        println(RESULT_PRINT_START_MESSAGE)
    }
    
    fun printCarPosition(cars: List<Car>) {
        cars.forEach { car ->
            println("${car.name} : ${"-".repeat(car.position)}")
        }
        println()
    }

    fun printWinner(winners: List<Car>) {
        val winnerNames = winners.joinToString(", ") { it.name }
        println(winnerNames + "이(가) 최종 우승했습니다.")
    }
}
