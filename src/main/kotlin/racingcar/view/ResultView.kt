package racingcar.view

import racingcar.model.Car

object ResultView {
    fun printInitial() {
        println("실행 결과")
    }

    fun printResult(cars: List<Car>) {
        for (car in cars) {
            printResult(car.name, car.position)
        }
    }

    fun printEmptyLine() = println()

    private fun printResult(name: String, count: Int) {
        print("$name: ")
        repeat(count) {
            print("-")
        }
        println()
    }
}
