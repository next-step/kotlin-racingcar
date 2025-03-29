package controller

import model.GameHistories
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

        val gameHistories = GameHistories()
        repeat(rounds) {
            racingCars.moveAll()
            gameHistories.add(racingCars)
        }
        resultView.printRaceResult(gameHistories, Referee(racingCars).judge())
    }
}
