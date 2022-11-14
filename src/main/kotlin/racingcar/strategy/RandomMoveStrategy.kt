package racingcar.strategy

class RandomMoveStrategy : CarMoveStrategy {
    override fun generate(): Int = seed.random()

    companion object {
        private const val START_VALUE = 0
        private const val LIMIT_VALUE = 10

        private val seed = (START_VALUE until LIMIT_VALUE)
    }
}
