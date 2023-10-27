package racingcar.util

import java.util.Random

class RandomNumGenerator : NumGenerator {
    override fun getNextInt(bound: Int): Int {
        val random = Random()
        return random.nextInt(bound)
    }
}
