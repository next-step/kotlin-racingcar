package racing.v2.domain

import kotlin.random.Random

object RandomNumberGenerator : NumberGenerator {
    override fun generate(upperBound: Int) = Random.nextInt(upperBound)
}
