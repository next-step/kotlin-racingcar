package racingcar.view

import racingcar.domain.Cars

class OutputConsoleView : OutputView {
    fun printResultMsg() {
        println("실행 결과")
    }

    override fun printCarsPosition(cars: Cars) {
        cars.carList.forEach { car ->
            print("${car.getName()} : ")
            println("-".repeat(car.position))
        }
        println()
    }

    fun printWinners(winners: List<String>) {
        print("${winners}가 최종 우승했습니다.")
    }
}
