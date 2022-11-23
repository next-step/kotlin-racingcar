package racingcar

import java.security.SecureRandom

const val MINIMUM_BOUND = 4

sealed class ForwardStrategy {
    abstract fun forward(): Int

    object CarForward : ForwardStrategy() {
        override fun forward(): Int = SecureRandom.getInstanceStrong().nextInt(MAXIMUM_BOUND)
    }

    object CarPassForward : ForwardStrategy() {
        override fun forward(): Int = MAXIMUM_BOUND - 1
    }

    object CarNotForward : ForwardStrategy() {
        override fun forward(): Int = MINIMUM_BOUND - 1
    }

    companion object {
        private const val MAXIMUM_BOUND = 10
    }
}
