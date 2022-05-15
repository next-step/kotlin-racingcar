package step3.util

import java.security.SecureRandom

object RandomGenerator {
    fun generate(minValue: Int, maxValue: Int): Int {
        val secureRandom = SecureRandom()
        return minValue + secureRandom.nextInt(minValue + (maxValue + 1))
    }
}
