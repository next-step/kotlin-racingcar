package racing.model.move

import racing.model.generator.Generator

class MoveThresholdStrategy(
    private val generator: Generator,
) : MoveStrategy {

    override fun movable(): Boolean {
        return isOverThreshold(generator.generate())
    }

    private fun isOverThreshold(value: Int): Boolean {
        return value >= THRESHOLD
    }

    companion object {
        private const val THRESHOLD = 4
    }
}
