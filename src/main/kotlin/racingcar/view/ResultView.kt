package racingcar.view

import racingcar.GameBoard
import racingcar.car.Car

private fun showPositionBy(name: String, position: Int) = println("$name :${stringBy(position)}")

private fun stringBy(position: Int): String = "-".repeat(position)

class ResultView(private val gameBoard: GameBoard) {
    private val cars = gameBoard.cars
    private val longestNameSize = cars.map { it.name }.maxOf { it.length }

    fun showAllPositionsByStep() {
        println("\n실행 결과")
        repeat(gameBoard.moveCount) {
            showPositionsBy(it + 1)
            println()
        }
    }

    private fun showPositionsBy(step: Int) = cars.forEach { showPositionBy(it.displayName, it.positionBy(step)) }

    private val Car.displayName: String
        get() = displayNames.getOrPut(this) { getDisplayName(this.name) }
    private val displayNames = mutableMapOf<Car, String>()

    private fun getDisplayName(name: String): String {
        var displayName = name
        repeat(longestNameSize - name.length) { displayName += " " }
        return displayName
    }

    fun showWinners() = println("${gameBoard.winners.joinToString(", ") { it.name }} (이)가 최종 우승했습니다.")
}
