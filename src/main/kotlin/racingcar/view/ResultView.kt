package racingcar.view

import racingcar.domain.Car

object ResultView {
    fun showPosition(listCar: List<Car>) {
        printCurrentPosition(listCar)
    }

    fun showResultTitle() {
        println("\n[실행 결과]")
    }

    fun showWinner(winnerNames: List<String>) {
        println("${winnerNames.joinToString(", ")}가 최종 우승했습니다.")
    }

    private fun printCurrentPosition(listCar: List<Car>) {
        listCar.map { car ->
            print("${car.name} : ")
            (0 until car.position).map { print("-") }
            println("")
        }
        println("")
    }
}
