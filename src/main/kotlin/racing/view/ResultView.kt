package racing.view

import racing.model.Car

object ResultView {
    private const val POSITION_MARK = '-'

    fun printExecutionResultMessage() {
        println()
        println("실행 결과")
    }

    fun printCarsNameAndPosition(cars: List<Car>) {
        cars.forEach { printCarNameAndPosition(it) }
        println()
    }

    fun printWinnerNames(cars: List<Car>) {
        println("${generateWinnerNames(cars)}가 최종 우승했습니다.")
    }

    private fun printCarNameAndPosition(car: Car) {
        println("${car.name()} : ${generateCarPositionMark(car.position())}")
    }

    private fun generateCarPositionMark(position: Int): String {
        var positionMark = ""
        repeat(position) { positionMark += POSITION_MARK }
        return positionMark
    }

    private fun generateWinnerNames(cars: List<Car>): String {
        var names = cars[0].name()

        repeat(cars.size - 1) {
            val name = cars[it + 1].name()
            names += ", $name"
        }

        return names
    }
}
