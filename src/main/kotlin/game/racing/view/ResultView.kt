package game.racing.view

import game.racing.domain.Car

object ResultView {
    private const val RESULT_MESSAGE = "실행 결과"
    private const val POSITION_DELIMITER = "-"
    private const val CAR_NAME_DELIMITER = ","

    fun printResultIntroduction() {
        println(RESULT_MESSAGE)
    }

    private fun printCarPosition(car: Car) {
        println("${car.name} : ${POSITION_DELIMITER.repeat(car.position)}")
    }

    fun printResult(cars: List<Car>) {
        cars.forEach {
            printCarPosition(it)
        }
        println()
    }

    fun printWinner(winners: List<Car>) {
        val winnerNames = winners.joinToString(CAR_NAME_DELIMITER) { it.name }
        println("${winnerNames}가 최종 우승했습니다.")
    }

    fun printResults(resultList: List<List<Car>>) {
        resultList.forEach(this::printResult)
    }
}
