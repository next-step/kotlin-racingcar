package step3_4_5.domain.racing

import kotlin.random.Random

object RandomNumberGenerator : NumberGenerator {
    override fun generateNumber(): Int = Random.nextInt(from = FROM_ZERO, until = UNTIL_TEN)

    private const val FROM_ZERO = 0
    private const val UNTIL_TEN = 10
}
