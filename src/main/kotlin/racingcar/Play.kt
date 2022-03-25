package racingcar

import racingcar.domain.racing.RacingCarGame
import racingcar.view.InputView
import racingcar.view.ResultView

fun main() {
    val inputView = InputView()
    val carNames = inputView.carNames()
    val attemptCount = inputView.attemptCount()
    val resultView = ResultView().apply { printTitle() }
    RacingCarGame(
        carNames = carNames,
        attemptCount = attemptCount,
        onEachRace = resultView::printEachTurn
    )
        .play()
        .let(resultView::printWinner)
}
