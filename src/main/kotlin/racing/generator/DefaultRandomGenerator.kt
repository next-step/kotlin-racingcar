package racing.generator

import java.util.Random

class DefaultRandomGenerator(
    private val fixNumber: Int? = null
) : RandomGenerator {
    override fun getRandomNumber(bound: Int): Int {

        fixNumber?.let {
            return fixNumber
        }

        return Random().nextInt(bound)
    }
}
