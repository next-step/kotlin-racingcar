package carracing.strategy

import kotlin.random.Random

class DefaultRandomGenerator : RandomGenerator {
    override fun generate(): Int = Random.nextInt(0, 10)
}
