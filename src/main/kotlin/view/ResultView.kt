package view

import model.RacingCar

class ResultView {
    fun printRacingCarGameState(racingCars: List<RacingCar>) {
        for(racingCar in racingCars) {
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
