package step3

import step3.domain.RacingGame
import step3.view.input.impl.InputViewWithCarNameImpl
import step3.view.result.DefaultResultView
import step3.view.result.history.impl.RacingGameHistoryWithCarNameViewImpl

fun main() {
    val inputView = InputViewWithCarNameImpl()
    val resultView = DefaultResultView(racingGameHistoryView = RacingGameHistoryWithCarNameViewImpl())

    inputView.printInputViewForTotalCarCount()
    val racingCarNameList = readln().trim().split(",")

    inputView.printInputViewForTotalTryCount()
    val totalTryCount = readln().toInt()

    val racingGame = RacingGame(racingCarNameList.size, totalTryCount)

    racingCarNameList.forEach {
        racingGame.addRacingCar(it)
    }

    racingGame.nextStepAll()

    println()

    resultView.printRacingGameResult(racingGame)
}
