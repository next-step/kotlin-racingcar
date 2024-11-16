package racingcar

import java.util.Random

class RandomNumberGenerator(
    private val from: Int,
    private val until: Int,
) {
    private val random: Random = Random()

    fun generateRandomNumber(): Int {
        return random.nextInt(from, until)
    }
}
