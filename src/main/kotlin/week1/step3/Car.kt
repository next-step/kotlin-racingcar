package week1.step3

import org.jetbrains.annotations.TestOnly

class Car(val name: String) {
    var forwardCount = 0
        private set

    fun updateForwardCount() {
        if (availableForward()) {
            forwardCount++
        }
    }

    @TestOnly
    fun setupForwardCondition() {
        forwardCount = FORWARD_CONDITION_MIN_NUM
    }

    @TestOnly
    fun setupForwardLimitCondition() {
        forwardCount = FORWARD_CONDITION_MIN_NUM - 1
    }

    private fun availableForward(): Boolean = FORWARD_CONDITION_RANGE.random() >= FORWARD_CONDITION_MIN_NUM

    companion object {
        private val FORWARD_CONDITION_RANGE = 0..9
        private const val FORWARD_CONDITION_MIN_NUM = 4
    }
}
