package racing.model

import racing.condition.RacingCondition

class Car(var dist: Int = 0) {
    fun doRacing(round: Int, conditions: List<RacingCondition>) {
        if (conditions.any { condition -> condition.predicate(round) }) dist += 1
    }
}
