package racingcar

import racingcar.race.Race
import racingcar.view.InputView
import racingcar.view.ResultView

class GameBoard(minCarCount: Int = 1, minMoveCount: Int = 1) {
    private val inputView = InputView(minCarCount, minMoveCount)
    private val race = Race(inputView.carCount, inputView.moveCount)
    private val resultView = ResultView(race)

    fun showResult() = resultView.showResult()
}
