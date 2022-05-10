package racingcar.utils

class RandomGeneratorImpl : RandomGenerator {

    override fun generateNumberWithin(range: IntRange): Int {
        val min = range.first
        val max = range.last

        return (min..max).random()
    }
}
