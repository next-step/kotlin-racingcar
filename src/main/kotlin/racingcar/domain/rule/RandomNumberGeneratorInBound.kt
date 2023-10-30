package racingcar.domain.rule

class RandomNumberGeneratorInBound(
    private val range: IntRange,
) {
    fun getNumber(): Int = range.random()

    companion object {
        fun default(): RandomNumberGeneratorInBound = RandomNumberGeneratorInBound(
            range = 0..9
        )
    }
}
