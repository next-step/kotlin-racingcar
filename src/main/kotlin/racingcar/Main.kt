package racingcar

import racingcar.model.RacingCarGame
import racingcar.model.strategy.MoveStrategy
import racingcar.utils.InputUtils

fun main() {
    val inputView = InputUtils.askQuestions()

    val racingCarGame = RacingCarGame.ready(inputView.carCount)

    val moveStrategy = MoveStrategy()
    for (i in 1..inputView.gameCount) {
        val resultViews = racingCarGame.moveOnce(moveStrategy)
        resultViews.printResults()
    }
}
