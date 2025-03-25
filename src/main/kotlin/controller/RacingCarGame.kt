package controller

import model.RacingCars
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
        val racingCars = RacingCars.fromNames(names)

        resultView.printRaceResultMessage()
        repeat(rounds) {
            racingCars.moveAll()
            resultView.printRacingCarGameState(racingCars)
        }
        resultView.printWinners(Referee(racingCars).judge())
    }
}
