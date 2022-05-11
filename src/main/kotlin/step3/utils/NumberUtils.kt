package step3.utils

import kotlin.random.Random

class NumberUtils {

    companion object {
        fun getRandomNumber() = Random.nextInt(RANDOM_NUMBER_START, RANDOM_NUMBER_END)

        const val RANDOM_NUMBER_START = 0
        const val RANDOM_NUMBER_END = 10
    }
}
