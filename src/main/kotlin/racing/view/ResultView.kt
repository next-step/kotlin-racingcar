package racing.view

import racing.model.Car

object ResultView {
    private const val POSITION_MARK = '-'

    fun printExecutionResultMessage() {
        println()
        println("실행 결과")
    }

    fun printCarPositions(cars: List<Car>) {
        cars.forEach { printCarPosition(it) }
        println()
    }

    private fun printCarPosition(car: Car) {
        println("${car.name()} : ${generateCarPositionMark(car.position())}")
    }

    private fun generateCarPositionMark(position: Int): String {
        var positionMark = ""
        repeat(position) { positionMark += POSITION_MARK }
        return positionMark
    }
}
