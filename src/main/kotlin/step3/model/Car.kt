package step3.model

import step3.domain.Engine
import step3.domain.RandomEngine

class Car(private val engine: Engine = RandomEngine) {
    var proceedLevel = INITIAL_PROCEED_LEVEL
        private set

    fun proceed() {
        proceedLevel += engine.getMovableDistance()
    }

    companion object {
        private const val INITIAL_PROCEED_LEVEL = 0
    }
}
