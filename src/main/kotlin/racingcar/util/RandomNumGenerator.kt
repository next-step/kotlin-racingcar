package racingcar.util

import java.util.Random

private const val RANDOM_NUM_BOUND = 10

class RandomNumGenerator : NumGenerator {
    private val random = Random()

    override fun getNextInt(): Int {
        return random.nextInt(RANDOM_NUM_BOUND)
    }
}
