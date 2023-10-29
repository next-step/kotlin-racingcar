package racing.model.move

import racing.model.generator.Generator

class MoveRandomStrategy(
    private val generator: Generator,
) : MoveStrategy {
    private val threshold = 4
    override fun movable(): Boolean {
        return movingPolicy(generator.generate())
    }

    private fun movingPolicy(value: Int): Boolean {
        return value >= threshold
    }
}
