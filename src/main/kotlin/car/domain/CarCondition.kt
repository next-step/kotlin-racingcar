package car.domain

enum class CarCondition(private val threshold: Int) {
    GOOD(0),
    NORMAL(4),
    BAD(9),
    TERRIBLE(10);

    fun canGoForward(): Boolean = thresholdRange.random() >= threshold

    companion object {
        private val thresholdRange = GOOD.threshold..BAD.threshold
    }
}
