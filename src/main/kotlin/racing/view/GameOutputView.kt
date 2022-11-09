package racing.view

import racing.domain.Car

class GameOutputView {

    fun startGame() {
        println("실행 결과")
    }

    fun nextRound() {
        println()
    }

    fun printRaceStatus(cars: List<Car>) {
        cars.forEach { printPositions(it) }
    }

    fun printPositions(car: Car) {
        println(POSITION_MARK.repeat(car.position))
    }

    companion object {
        const val POSITION_MARK = "-"
    }
}
