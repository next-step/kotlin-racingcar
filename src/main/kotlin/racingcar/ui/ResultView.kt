package racingcar.ui

import racingcar.domain.Car

object ResultView {
    private const val MARK = "-"

    fun printResultMessage() {
        println("실행 결과")
    }

    fun printTraceOfRound(round: Int, cars: List<Car>) {
        println("[ROUND ${round + 1}]")
        cars.forEach { car ->
            print("${car.name} : ")
            repeat(car.distance) {
                print(MARK)
            }
            println()
        }
        println()
    }
}
