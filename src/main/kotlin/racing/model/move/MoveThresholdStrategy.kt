package racing.model.move

import racing.model.generator.Generator

class MoveThresholdStrategy(
    private val generator: Generator,
) : MoveStrategy {
    private val threshold = 4
    override fun movable(): Boolean {
        return isOverThreshold(generator.generate())
    }

    private fun isOverThreshold(value: Int): Boolean {
        return value >= threshold
    }
}
