package step3.view

import step3.domain.Car

class OutputView {
    fun printResult() {
        println("\n실행 결과")
    }

    fun printPositionOfCars(cars: List<Car>) {
        cars.map { car ->
            println("${car.name} : ${"-".repeat(car.position)}")
        }
        println()
    }

    fun printWinner(winners: List<String>) {
        println("${winners.joinToString(", ")}가 최종 우승했습니다.")
    }
}
