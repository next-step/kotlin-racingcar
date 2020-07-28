package week1.step3

class Car {
    var forwardCount = 1
        private set

    fun updateForwardCount() {
        if (availableForward()) {
            forwardCount++
        }
    }

    private fun availableForward(): Boolean = FORWARD_CONDITION_RANGE.random() >= FORWARD_CONDITION_MIN_NUM

    companion object {
        private val FORWARD_CONDITION_RANGE = 0..9
        private const val FORWARD_CONDITION_MIN_NUM = 4
    }
}
