package number

import kotlin.random.Random

object Numbers {
    const val MIN_RANDOM_NUMBER = 0
    const val MAX_RANDOM_NUMBER = 10

    fun toInt(value: String): Int {
        return value.toIntOrNull() ?: throw IllegalArgumentException("value는 숫자여야 합니다. value : $value")
    }

    fun randomToRacing(): Int {
        return Random.nextInt(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER)
    }
}
