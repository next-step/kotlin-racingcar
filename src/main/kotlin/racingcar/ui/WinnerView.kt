package racingcar.ui

import racingcar.game.GameResult
import racingcar.game.GameWinner

object WinnerView {
    private const val WINNER_NAME_SEPARATOR = ","

    fun run(results: List<GameResult>) {
        println()

        val winners = GameWinner.of(results)

        println("${winners.joinToString(WINNER_NAME_SEPARATOR)} 가 최종 우승했습니다.")
    }
}
