package racingcar.domain

interface IntRandom {
    fun next(): Int

    class Smart(private val range: IntRange) : IntRandom {
        override fun next() = range.random()
    }
}
