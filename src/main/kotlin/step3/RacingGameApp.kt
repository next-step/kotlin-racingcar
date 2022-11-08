package step3

import step3.domain.RacingGame
import step3.view.input.impl.InputViewWithCarCountImpl
import step3.view.result.DefaultResultView

fun main() {
    val inputView = InputViewWithCarCountImpl()
    val resultView = DefaultResultView()

    inputView.printInputViewForTotalCarCount()
    val totalCarCount = readln().toInt()

    inputView.printInputViewForTotalTryCount()
    val totalTryCount = readln().toInt()

    val racingGame = RacingGame(totalCarCount, totalTryCount)

    (1..totalCarCount).forEach {
        racingGame.addRacingCar("car$it")
    }

    racingGame.nextStepAll()

    println()

    resultView.printRacingGameResult(racingGame)
}
