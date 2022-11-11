package racingcar

class Random : ForwardStrategy {
    override fun generateInt(): Int = seed.random()

    companion object {
        private const val RANDOM_SEED = 9
        private val seed = (0..RANDOM_SEED)
        val minValue = seed.first
        val maxValue = seed.last
    }
}
