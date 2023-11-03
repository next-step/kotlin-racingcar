package racingcar.domain.rule

class RandomNumberGenerator(
    private val range: IntRange = 0..9,
) {
    fun getNumber(): Int = range.random()
}
