package view

import model.CarHistories
import model.GameHistories

class ResultView {
    fun printRaceResult(gameHistories: GameHistories, winners: List<String>) {
        println("\nRace Results:")
        printGameHistories(gameHistories)
        printWinners(winners)
    }

    private fun printGameHistories(gameHistories: GameHistories) {
        gameHistories.histories.forEach {
            printCarHistories(it)
        }
    }

    private fun printCarHistories(it: CarHistories) {
        it.histories.forEach { history -> println("${history.name} : " + "-".repeat(history.moved)) }
        println()
    }

    private fun printWinners(winnerNames: List<String>) {
        println("Winners: ${winnerNames.joinToString(", ")}")
    }
}
