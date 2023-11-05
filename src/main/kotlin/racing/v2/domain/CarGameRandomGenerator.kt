package racing.v2.domain

import kotlin.random.Random

object CarGameRandomGenerator : RandomGenerator {
    override fun nextInt(upperBound: Int) = Random.nextInt(upperBound)
}
