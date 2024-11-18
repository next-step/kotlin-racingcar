package racingcar

import kotlin.random.Random

class RandomNumberGenerator(
    val from: Int = 0,
    val until: Int = 0,
) : NumberGenerator {
    override fun generate(): Int {
        return if (from < until) {
            Random.nextInt(from, until)
        } else {
            Random.nextInt()
        }
    }
}
