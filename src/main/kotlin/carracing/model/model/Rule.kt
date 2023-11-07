package carracing.model.model

import kotlin.random.Random

sealed class Rule {
    abstract fun isMoveAllowed(): Boolean

    class RandomRule : Rule() {
        override fun isMoveAllowed(): Boolean = Random.nextInt(10) >= 4
    }

    class AlwaysMoveRule: Rule() {
        override fun isMoveAllowed(): Boolean = true
    }

    class NoMoveRule: Rule() {
        override fun isMoveAllowed(): Boolean = false

    }
}