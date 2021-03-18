package racingcar.view

import racingcar.domain.Car

class ResultView(private val cars: List<Car>) {

    fun print() {
        println("실행 결과")
        printEachTurn()
    }

    private fun attemptCount() = cars[0].history.size

    private fun printEachTurn() {
        for (i in 1..attemptCount()) {
            cars.forEach { printCar(it, i) }
            println()
        }
    }

    private fun printCar(car: Car, attempt: Int) {
        print("${car.name} : ")
        println("-".repeat(car.currentPosition(attempt)))
    }
}
