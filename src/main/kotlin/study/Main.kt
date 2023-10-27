package study

import study.domain.RaceGame
import study.view.InputView
import study.view.ResultView

fun main() {
    val carCount = InputView.askCarCount()
    val totalRound = InputView.askTotalRound()

    val raceGame = RaceGame.of(carCount, totalRound)
    val raceResult = raceGame.play()

    ResultView.showRaceResult(raceResult)
}
