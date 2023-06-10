package racing.domain.generator

import kotlin.random.Random
import kotlin.random.nextInt

object RandomNumberGenerator : NumberGenerator {

    private val RANDOM: Random = Random(seed = 0)
    private val RANDOM_RANGE: IntRange = 0 until 10

    override fun generate(): Int = RANDOM.nextInt(range = RANDOM_RANGE)
}
