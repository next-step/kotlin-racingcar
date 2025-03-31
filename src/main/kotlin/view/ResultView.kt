package view

import model.RacingCars

class ResultView {
    fun printRaceResult(histories: List<RacingCars>, winners: List<String>) {
        println("\nRace Results:")
        printHistories(histories)
        printWinners(winners)
    }

    private fun printHistories(histories: List<RacingCars>) {
        histories.forEach(::printCarsHistory)
    }

    private fun printCarsHistory(racingCars: RacingCars) {
        racingCars.racingCars.forEach {
            println("${it.name} : " + "-".repeat(it.getMoved()))
        }
        println()
    }

    private fun printWinners(winnerNames: List<String>) {
        println("Winners: ${winnerNames.joinToString(", ")}")
    }
}
