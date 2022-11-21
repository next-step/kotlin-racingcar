package racingcar.move

import java.security.SecureRandom

sealed class ForwardStrategy {
    abstract fun forward(): Int

    object CarForward : ForwardStrategy() {
        override fun forward(): Int = SecureRandom.getInstanceStrong().nextInt(MAXIMUM_BOUND)
    }

    companion object {
        private const val MAXIMUM_BOUND = 10
    }
}
