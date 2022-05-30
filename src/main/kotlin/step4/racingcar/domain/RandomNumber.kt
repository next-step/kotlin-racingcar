package step4.racingcar.domain

object RandomNumber : NumberGenerator {
    override fun generate() = RANDOM_RANGE.random()

    private val RANDOM_RANGE = (0..9)
}
