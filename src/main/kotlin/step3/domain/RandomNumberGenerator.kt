package step3.domain

import java.util.Random

class RandomNumberGenerator : NumberGenerator {

    private val random = Random()

    companion object {
        private const val MAX = 10
    }

    override fun generate(): Int {
        return random.nextInt(MAX)
    }
}
