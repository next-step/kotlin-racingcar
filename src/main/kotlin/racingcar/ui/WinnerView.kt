package racingcar.ui

import racingcar.game.GameResult
import racingcar.painter.GameWinnerPainter

object WinnerView {

    fun run(results: List<GameResult>) {
        println()
        println(GameWinnerPainter.from(results))
    }
}
