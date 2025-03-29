package view

import model.RacingCars

class ResultView {
    fun printRacingCarGameState(racingCars: RacingCars) {
        for(racingCar in racingCars.getRacingCars()) {
            println("${racingCar.name} : " + "-".repeat(racingCar.moved))
        }
        println()
    }

    fun printRaceResultMessage() {
        println("\nRace Results:")
    }

    fun printWinners(winnerNames: List<String>) {
        println("Winners: ${winnerNames.joinToString(", ")}")
    }
}
