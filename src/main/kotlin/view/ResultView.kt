package view

import model.RacingCars

class ResultView {
    fun printRacingCarGameState(racingCars: RacingCars) {
        for(racingCar in racingCars.getRacingCars()) {
            println("${racingCar.getName()} : " + "-".repeat(racingCar.getCurrentState()))
        }
        println()
    }

    fun printRaceResultMessage() {
        println("Race Results:")
    }

    fun printWinners(winnerNames: List<String>) {
        println("Winners: ${winnerNames.joinToString(", ")}")
    }
}
