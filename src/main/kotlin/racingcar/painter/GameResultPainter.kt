package racingcar.painter

import racingcar.car.Position
import racingcar.game.GameResult

object GameResultPainter {
    private val toDash: Position.() -> String = {
        "-".repeat(value)
    }

    fun from(gameResult: List<GameResult>): String =
        gameResult.joinToString(separator = "\n\n") {
            it.cars.joinToString(separator = "\n") { car -> car.position().toDash() }
        }
}
