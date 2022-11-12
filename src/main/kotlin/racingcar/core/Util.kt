package racingcar.core

import java.util.Random

object Util {
    private const val RANDOM_BOUND = 10

    fun getRandomNumber(): Int =
        Random().nextInt(RANDOM_BOUND)
}
