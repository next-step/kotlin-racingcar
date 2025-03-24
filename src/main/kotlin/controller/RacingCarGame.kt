package controller

import model.RacingCar
import model.Referee
import view.InputView
import view.ResultView

fun main() {
    RacingCarGame(InputView(), ResultView()).run()
}

class RacingCarGame(private val inputView: InputView, private val resultView: ResultView) {
    fun run() {
        val names = inputView.enterCarNames()
        val rounds = inputView.enterAmountOfRounds()

        val racingCars: MutableList<RacingCar> = mutableListOf()
        for (name: String in names) {
            racingCars.addFirst(RacingCar(name))
        }
        resultView.printRaceResultMessage()
        repeat(rounds) {
            resultView.printRacingCarGameState(racingCars)
            moveRacingCars(racingCars)
        }
        resultView.printWinners(Referee(racingCars).judge())
    }

    private fun moveRacingCars(racingCars: List<RacingCar>) {
        racingCars.forEach { car -> car.moveRandomly() }
    }
}
