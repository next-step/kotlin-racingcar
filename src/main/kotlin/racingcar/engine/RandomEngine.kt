package racingcar.engine

class RandomEngine : Engine {
    override fun advancePoint(): Int {
        val random = RANDOM_INT_RANGE.random()
        return if (random >= DATUM_POINT) FORWARD_POINT else STOP_POINT
    }

    companion object {
        val RANDOM_INT_RANGE = (0..9)
        private const val DATUM_POINT = 4
        private const val FORWARD_POINT = 1
        private const val STOP_POINT = 0
    }
}
