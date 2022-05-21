package step4.racingcar.racingcar

object RandomNumber : NumberGenerator {
    override fun generate() = RANDOM_RANGE.random()

    private val RANDOM_RANGE = (0..9)
}
