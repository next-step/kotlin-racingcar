package step3.view

import step3.domain.Car

object OutputView {
    fun printResult() {
        println("\n실행 결과")
    }

    fun printPositionOfCars(cars: List<Car>) {
        cars.map { car ->
            println("${car.name} : ${"-".repeat(car.getPosition())}")
        }
        println()
    }

    fun printWinner(results: List<Car>) {
        val maxPosition = results.maxBy { it.getPosition() }.getPosition()

        val winners = results.filter { it.getPosition() == maxPosition }
            .map { it.name }

        println("${winners.joinToString(", ")}가 최종 우승했습니다.")
    }
}
