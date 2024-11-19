package racingcars

import kotlin.random.Random

class SingleDigitRandomNumberGenerator : RandomNumberGenerator {
    override fun generate(): Int {
        val from = 0
        val until = 10
        return Random.nextInt(from, until)
    }
}
