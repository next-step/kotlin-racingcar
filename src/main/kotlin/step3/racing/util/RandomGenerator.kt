package step3.racing.util

open class RandomGenerator {
    open fun getInt(range: IntRange): Int {
        return range.random()
    }
}
