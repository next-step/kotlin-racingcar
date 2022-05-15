package racingcar.view

import racingcar.domain.Car

object ResultView {
    fun show(listCar: List<Car>) {
        printCurrentPosition(listCar)
    }

    fun showResultTitle() {
        println("\n[실행 결과]")
    }

    private fun printCurrentPosition(listCar: List<Car>) {
        listCar.map { car ->
            (0 until car.position).map { print("-") }
            println("")
        }
        println("")
    }
}
