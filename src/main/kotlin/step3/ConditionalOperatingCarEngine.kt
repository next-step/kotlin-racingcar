package step3

class ConditionalOperatingCarEngine(
    private val conditionChecker: () -> Boolean
) {

    fun move(): Distance {
        val isAbleToMove = conditionChecker.invoke()

        return if (isAbleToMove) Distance(1) else Distance(0)
    }

    companion object {
        val RANDOM = ConditionalOperatingCarEngine { (Math.random() * 10).toInt() >= 4 }
    }
}
