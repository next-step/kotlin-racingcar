package racing.model.move

import kotlin.random.Random

class RandomEngine {
    private val random = Random(99)
    fun generate(): Int {
        return random.nextInt(1, 9)
    }
}
