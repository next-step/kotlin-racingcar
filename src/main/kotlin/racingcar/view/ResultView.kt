package racingcar.view

import racingcar.GameBoard
import racingcar.car.Car

private fun showPositionBy(name: String, position: Int) = println("$name :${stringBy(position)}")

private fun stringBy(position: Int): String = "-".repeat(position)

class ResultView(gameBoard: GameBoard) {
    private val cars: List<Car> = gameBoard.cars
    private val winners: List<Car> = gameBoard.winners
    private val moveCount: Int = gameBoard.moveCount
    private val maxNameLength: Int = cars.map { it.name }.maxOf { it.length }
    private val displayNames: Map<Car, String> = cars.associateWith { getDisplayName(it.name) }

    private fun getDisplayName(name: String): String = name + " ".repeat(maxNameLength - name.length)

    private fun showPositionsBy(step: Int) = cars.forEach { showPositionBy(displayNames[it]!!, it.positionBy(step)) }

    fun showAllPositionsByStep() {
        println("\n실행 결과")
        repeat(moveCount) {
            showPositionsBy(it + 1)
            println()
        }
    }

    fun showWinners() = println("${winners.joinToString(", ") { it.name }} (이)가 최종 우승했습니다.")
}
