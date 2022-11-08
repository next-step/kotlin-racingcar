package step3.domain.game.random

import kotlin.random.Random

object DefaultRandomGenerator : RandomGenerator<Int> {

    override val randomPredicate: (Int) -> Boolean = { it > 4 }

    override val candidates: Collection<Int> = (0..9).toList()

    private val random = Random.Default

    override fun random(): Int = candidates.random(random)
}
