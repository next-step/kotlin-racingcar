package domain.racingcar

import domain.number.Numbers
import java.util.stream.IntStream
import kotlin.random.Random
import kotlin.streams.toList

class RandomConditions(conditions: List<Int>, count: Int) : Conditions {
    var conditions = conditions
        private set

    override fun makeConditionsToRacing(size: Int) {
        conditions = IntStream.range(START_INDEX, size)
            .map { Random.nextInt(Numbers.MIN_RANDOM_NUMBER, Numbers.MAX_RANDOM_NUMBER) }
            .toList()
    }

    override fun getSize(): Int {
        return conditions.size
    }

    companion object {
        private const val START_INDEX = 0
    }
}
