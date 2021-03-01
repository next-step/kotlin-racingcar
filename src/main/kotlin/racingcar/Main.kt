package racingcar

import racingcar.model.RacingCarGame
import racingcar.strategy.RandomMoveStrategy
import racingcar.utils.InputUtils
import racingcar.view.ResultViews
import racingcar.view.WinnerView

fun main() {
    val inputDto = InputUtils.askQuestions()

    val racingCarGame = RacingCarGame.ready(inputDto.carNames, RandomMoveStrategy())

    for (i in 1..inputDto.gameCount) {
        val resultViews: ResultViews = racingCarGame.moveOnce()
        resultViews.printResults()
    }

    val winnerView: WinnerView = racingCarGame.finish()
    winnerView.printWinner()
}
