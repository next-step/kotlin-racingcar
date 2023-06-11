package step3.domain

import kotlin.random.Random

class ConditionalOperatingCarEngine(
    private val conditionChecker: () -> Boolean
) {

    fun move(): Distance {
        val isAbleToMove = conditionChecker.invoke()

        return if (isAbleToMove) Distance(1) else Distance(0)
    }

    companion object {
        val RANDOM = ConditionalOperatingCarEngine { Random.nextInt(0, 10) >= 4 }
    }
}
