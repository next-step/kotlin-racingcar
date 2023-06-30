package racingcar.util

object RandomNumberGenerator : NumberGenerator {
    private const val RANDOM_NUMBER_BOUND =
        NumberGenerator.MAX_GENERATED_NUMBER - NumberGenerator.MIN_GENERATED_NUMBER + 1

    override fun getNumber(): Int = (Math.random() * RANDOM_NUMBER_BOUND).toInt() + NumberGenerator.MIN_GENERATED_NUMBER
}
