package number

import java.util.stream.IntStream
import kotlin.random.Random
import kotlin.streams.toList

object Numbers {
    const val START_INDEX = 0
    const val MIN_RANDOM_NUMBER = 1
    const val MAX_RANDOM_NUMBER = 10

    fun toInt(value: String): Int {
        return value.toIntOrNull() ?: throw IllegalArgumentException("value는 숫자여야 합니다. value : $value")
    }

    fun makeRandomsToRacing(count: Int): List<Int> {
        return IntStream.range(START_INDEX, count)
            .map { Random.nextInt(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER) }
            .toList()
    }

    fun randomToRacing(): Int {
        return Random.nextInt(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER)
    }
}
