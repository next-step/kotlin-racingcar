package controller

import model.RacingCar
import view.InputView
import view.ResultView

fun main() {
    RacingCarGame(InputView(), ResultView()).run()
}

class RacingCarGame(private val inputView: InputView, private val resultView: ResultView) {
    fun run() {
        val cars = inputView.enterAmountOfCars()
        val rounds = inputView.enterAmountOfRounds()

        val racingCars: List<RacingCar> = List(cars) { RacingCar() }
        resultView.printRaceResultMessage()
        repeat(rounds) {
            resultView.printRacingCarGameState(racingCars)
            moveRacingCars(racingCars)
        }
    }

    private fun moveRacingCars(racingCars: List<RacingCar>) {
        racingCars.forEach { car -> car.moveRandomly() }
    }
}
