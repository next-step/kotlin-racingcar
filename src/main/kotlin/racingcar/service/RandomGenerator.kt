package racingcar.service

interface RandomGenerator {
    fun generate(): Int
}

class RangeRandomGenerator : RandomGenerator {
    override fun generate(): Int {
        val range = 0..9

        return range.random()
    }
}
