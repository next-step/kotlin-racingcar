package racingcar.painter

import racingcar.game.GameResult

object GameWinnerPainter {
    private const val SEPARATOR_BETWEEN_NAME = ", "

    fun from(gameResult: List<GameResult>): String {
        val last = gameResult.last().cars
        val maximum = last.maxOfOrNull { it.position().value } ?: 0
        val winnerNames = last
            .filter { it.position().value == maximum }
            .joinToString(SEPARATOR_BETWEEN_NAME) { it.name() }

        return "${winnerNames}가 최종 우승했습니다."
    }
}
