package week1.step3

class Car {
    var forwardCount = 1
        private set

    fun updateForwardCount() {
        if (availableForward()) {
            forwardCount++
        }
    }

    private fun availableForward(): Boolean = WINNER_NUMBER_RANGE.random() > WINNER_NUMBER_CUT_LINE

    companion object {
        private val WINNER_NUMBER_RANGE = 0..9
        private const val WINNER_NUMBER_CUT_LINE = 3
    }
}
