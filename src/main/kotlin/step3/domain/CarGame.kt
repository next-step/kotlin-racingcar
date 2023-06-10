package step3.domain

import step3.domain.strategy.MoveStrategy

class CarGame(private val moveStrategy: MoveStrategy) {
    fun play(carCount: Int, tryCount: Int): GameResult {
        val carPositions = CarPositions.of(carCount)
        val result = GameResult.of(carPositions)

        repeat(tryCount) {
            val movedPosition = result.getLastPositions().moveBy { moveStrategy.movable() }
            result.add(movedPosition)
        }
        return result
    }
}
