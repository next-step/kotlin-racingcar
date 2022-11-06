package step3_racingcar.util.random

class RandomNumber(
    private val range: IntRange
) : RandomUtil {
    override fun generate() = range.random()
}
