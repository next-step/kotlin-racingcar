package step3.util

import java.security.SecureRandom

object RandomGenerator {

    private val secureRandom = SecureRandom()

    fun generate(minValue: Int, maxValue: Int): Int {
        return minValue + secureRandom.nextInt(minValue + (maxValue + 1))
    }
}
