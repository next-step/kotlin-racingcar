package carracing.model.model

import kotlin.random.Random

data class Car(val number: Int) {
    fun move(rule: Rule): Int = when(rule.isMoveAllowed()) {
        true -> 1
        false -> 0
    }
}
