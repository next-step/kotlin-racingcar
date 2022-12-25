package racingcar

import racingcar.ui.RaceGameController
import racingcar.ui.view.InputView
import racingcar.ui.view.ResultView

fun main() {
    val carNames = InputView.getCarNames()
    val totalRound = InputView.getTotalRound()

    val race = RaceGameController.readyForRace(carNames, totalRound)
    val raceResult = RaceGameController.runRace(race)
    val winners = RaceGameController.findWinner(raceResult)

    ResultView.printRaceResult(raceResult, winners)
}
