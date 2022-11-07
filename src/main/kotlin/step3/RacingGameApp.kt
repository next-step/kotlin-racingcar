package step3

import step3.domain.RacingGame
import step3.view.input.impl.DefaultInputCarCountView
import step3.view.result.DefaultResultView

fun main() {
    val defaultInputCarCountView = DefaultInputCarCountView()
    val resultView = DefaultResultView()

    defaultInputCarCountView.printInputViewForTotalCarCount()
    val totalCarCount = readln().toInt()

    defaultInputCarCountView.printInputViewForTotalTryCount()
    val totalTryCount = readln().toInt()

    val racingGame = RacingGame(totalCarCount, totalTryCount)

    (1..totalCarCount).forEach {
        racingGame.addRacingCar("test-$it")
    }

    racingGame.nextStepAll()

    println()

    resultView.printRacingGameResult(racingGame)
}
