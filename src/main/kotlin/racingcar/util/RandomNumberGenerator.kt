package racingcar.util

class RandomNumberGenerator : NumberGenerator {
    override fun getNumber(): Int = (Math.random() * RANDOM_NUMBER_BOUND).toInt()

    companion object {
        private const val RANDOM_NUMBER_BOUND = 10
    }
}
