package racingcar.util

import java.util.Random

private const val RANDOM_NUM_BOUND = 10

class RandomNumGenerator : NumGenerator {
    override fun getNextInt(): Int {
        return random.nextInt(RANDOM_NUM_BOUND)
    }

    companion object {
        private val random = Random()
    }
}
