package racingcar.util

import java.util.Random

private const val RANDOM_NUM_BOUND = 10

class RandomNumGenerator : NumGenerator {
    override fun getNextInt(): Int {
        val random = Random()
        return random.nextInt(RANDOM_NUM_BOUND)
    }
}
