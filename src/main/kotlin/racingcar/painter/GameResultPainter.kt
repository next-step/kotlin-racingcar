package racingcar.painter

import racingcar.car.Position
import racingcar.game.GameResult

object GameResultPainter {
    private const val SEPARATOR_BETWEEN_ROUND = "\n\n"
    private const val SEPARATOR_BETWEEN_CAR = "\n"
    private const val DASH = "-"

    private val toDash: Position.() -> String = {
        DASH.repeat(value)
    }

    fun from(gameResult: List<GameResult>): String =
        gameResult.joinToString(SEPARATOR_BETWEEN_ROUND) {
            it.cars.joinToString(SEPARATOR_BETWEEN_CAR) { car ->
                "${car.name()} : ${car.position().toDash()}"
            }
        }
}
