package racingcar

import java.util.Random

class RandomNumberGenerator(
    val from: Int = 0,
    val until: Int = 0,
) : NumberGenerator {
    private val random: Random = Random()

    override fun generate(): Int {
        return if (from < until) {
            random.nextInt(from, until)
        } else {
            random.nextInt()
        }
    }
}
