package view

import model.RacingCar

class ResultView {
    fun printRacingCarGameState(racingCars: List<RacingCar>) {
        for(racingCar in racingCars) {
            println("-".repeat(racingCar.getCurrentState()))
        }
        println()
    }

    fun printRaceResultMessage() {
        println("Race Results:")
    }
}
