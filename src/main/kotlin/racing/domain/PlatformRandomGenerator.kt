package racing.domain

import kotlin.random.Random

internal class PlatformRandomGenerator : RandomGenerator {
    override fun nextInt(max: Int): Int {
        return Random.nextInt(max + 1)
    }
}
