package racingcar.view

import racingcar.car.Car

object ResultView {

    private const val RACING_RESULT = "실행 결과"

    fun printResult() {
        println()
        println(RACING_RESULT)
        println()
    }

    fun printCarPositions(cars: List<Car>) {
        cars.forEach { car ->
            print("${car.getName()} : ")
            repeat(car.getPosition()) {
                print("-")
            }
            println()
        }
        println()
    }

    fun printWinners(cars: List<Car>) {
        println("최종 우승자는 ${cars.joinToString { it.getName() }}")
    }
}
