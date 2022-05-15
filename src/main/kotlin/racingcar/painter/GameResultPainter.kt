package racingcar.painter

import racingcar.car.Position
import racingcar.game.GameResult

object GameResultPainter {
    fun from(gameResult: List<GameResult>): String {
        val toDash: Position.() -> String = {
            "-".repeat(value)
        }

        return gameResult.joinToString(separator = "\n\n") {
            it.cars.joinToString(separator = "\n") { car -> car.position().toDash() }
        }
    }
}
