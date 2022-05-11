package racingcar.utils

class RandomNumberGenerator : NumberGenerator {

    override fun executeRangeOf(range: IntRange): Int {
        val min = range.first
        val max = range.last

        return (min..max).random()
    }
}
