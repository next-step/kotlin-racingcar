package carracing

import kotlin.random.Random

class RandomNumberGenerator : NumberGenerator {
    override fun generate(): Int {
        return Random.nextInt(10)
    }
}
