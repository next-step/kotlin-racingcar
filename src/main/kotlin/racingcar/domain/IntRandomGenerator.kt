package racingcar.domain

class IntRandomGenerator(
    start: Int,
    end: Int
): RandomGenerator<Int>(start, end) {
    override fun generate(start: Int, end: Int) = IntRange(start, end).random()
}
