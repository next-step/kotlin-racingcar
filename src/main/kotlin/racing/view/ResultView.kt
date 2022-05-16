package racing.view

import racing.model.Car
import racing.model.RacingGameResult

object ResultView {
    private const val POSITION_MARK = '-'

    fun printGameResult(racingGameResult: RacingGameResult) {
        printExecutionResultMessage()

        racingGameResult.result.forEach { printCarsNameAndPosition(it.cars) }

        printWinnerNames(racingGameResult.findWinners())
    }

    private fun printExecutionResultMessage() {
        println()
        println("실행 결과")
    }

    private fun printCarsNameAndPosition(cars: List<Car>) {
        cars.forEach { printCarNameAndPosition(it) }
        println()
    }

    private fun printCarNameAndPosition(car: Car) {
        println("${car.name()} : ${generateCarPositionMark(car.position())}")
    }

    private fun printWinnerNames(cars: List<Car>) {
        println("${generateWinnerNames(cars)}가 최종 우승했습니다.")
    }

    private fun generateCarPositionMark(position: Int): String {
        var positionMark = ""
        repeat(position) { positionMark += POSITION_MARK }
        return positionMark
    }

    private fun generateWinnerNames(cars: List<Car>): String {
        return cars.joinToString(",") { it.name() }
    }
}
