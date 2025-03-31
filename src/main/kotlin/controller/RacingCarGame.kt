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

        val histories: MutableList<RacingCars> = mutableListOf()
        repeat(rounds) {
            racingCars.moveAll()
            histories.add(racingCars.copy())
        }
        resultView.printRaceResult(histories.toList(), Referee(racingCars).judge())
    }
}
