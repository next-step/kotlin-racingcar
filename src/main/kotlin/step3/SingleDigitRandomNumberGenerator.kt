package step3

import kotlin.random.Random

class SingleDigitRandomNumberGenerator : RandomNumberGenerator {
    override fun generate(): Int {
        return Random.nextInt(0, 10)
    }
}
