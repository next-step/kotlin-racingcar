package step3.view

import step3.domain.Cars

class OutputView {
    fun printResult() {
        println("\n실행 결과")
    }

    fun printPositionOfCars(carHistories: List<Cars>) {
        carHistories.forEach { history ->
            history.values.forEach { car ->
                println("${car.name} : ${"-".repeat(car.position)}")
            }
            println()
        }
    }

    fun printWinner(winners: List<String>) {
        println("${winners.joinToString(", ")}가 최종 우승했습니다.")
    }
}
