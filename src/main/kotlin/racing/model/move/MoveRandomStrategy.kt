package racing.model.move

import racing.model.generator.Generator

class MoveRandomStrategy(
    private val generator: Generator,
) : MoveStrategy {
    override fun movable(): Boolean {
        return movingPolicy(generator.generate())
    }

    private fun movingPolicy(value: Int): Boolean {
        return value >= 4
    }
}
