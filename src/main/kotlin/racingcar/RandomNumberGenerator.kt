package racingcar

import kotlin.random.Random

class RandomNumberGenerator(
    private val startNum: Int = 0,
    private val endNum: Int = 0,
) : NumberGenerator {
    override fun generate(): Int {
        return if (startNum < endNum) {
            (startNum until endNum).random()
        } else {
            Random.nextInt()
        }
    }
}
