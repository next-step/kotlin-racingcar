package racingcar.domain

import java.security.SecureRandom

sealed class ForwardStrategy {
    abstract fun forward(): Boolean

    object DefaultForward : ForwardStrategy() {
        private const val MINIMUM_BOUND = 4
        private const val MAXIMUM_BOUND = 10

        override fun forward(): Boolean = SecureRandom.getInstanceStrong().nextInt(MAXIMUM_BOUND) >= MINIMUM_BOUND
    }
}
