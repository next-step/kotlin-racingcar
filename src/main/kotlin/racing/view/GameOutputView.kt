package racing.view

import racing.domain.Car

object GameOutputView {

    const val POSITION_MARK = "-"

    fun printStartGame() {
        println("실행 결과")
    }

    fun printNextRound() {
        println()
    }

    fun printRaceStatus(cars: List<Car>) {
        cars.forEach { printPositions(it) }
    }

    fun printPositions(car: Car) {
        println(POSITION_MARK.repeat(car.position))
    }
}
