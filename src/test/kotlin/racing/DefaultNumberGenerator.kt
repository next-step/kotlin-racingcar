package racing

import racing.generator.NumberGenerator

class DefaultNumberGenerator(
    private val number: Int
) : NumberGenerator {
    override fun nextInt(bound: Int): Int {
        return number
    }
}
