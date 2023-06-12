package racing.condition

import kotlin.random.Random

class RandomCondition : RacingCondition {
    override val predicate: (Int?) -> Boolean
        get() = { createRandomNum() >= 4 }

    private fun createRandomNum(): Int {
        return Random.nextInt(0, 9)
    }
}
