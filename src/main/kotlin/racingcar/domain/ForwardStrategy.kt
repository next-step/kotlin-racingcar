package racingcar.domain

sealed class ForwardStrategy {
    abstract fun forward(): Boolean

    object RandomRangeForward : ForwardStrategy() {
        private const val STD_VALUE = 4
        private const val MINIMUM_BOUND = 0
        private const val MAXIMUM_BOUND = 9
        private val RANGE = MINIMUM_BOUND..MAXIMUM_BOUND

        override fun forward(): Boolean = RANGE.random() >= STD_VALUE
    }
}
