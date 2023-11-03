package study

import study.domain.RaceGame
import study.view.InputView
import study.view.ResultView

fun main() {
    val carNames = InputView.askCarNames()
    val totalRound = InputView.askTotalRound()

    val raceGame = RaceGame.of(totalRound, carNames)
    val (winners, resultOfEachRound) = raceGame.play()

    ResultView.showRaceResult(winners, resultOfEachRound)
}
