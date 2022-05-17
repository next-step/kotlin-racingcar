package step3.util

import java.security.SecureRandom

class RandomGenerator : NumberGenerator {

    private val secureRandom = SecureRandom()

    override fun generate(minValue: Int, maxValue: Int): Int {
        return minValue + secureRandom.nextInt(minValue + (maxValue + 1))
    }
}
