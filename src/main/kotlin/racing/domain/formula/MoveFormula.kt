package racing.domain.formula

import racing.domain.generator.NumberGenerator

interface MoveFormula {

    fun move(): MoveState
}

class BasicRuleMoveFormula(private val numberGenerator: NumberGenerator) : MoveFormula {

    override fun move(): MoveState = when (numberGenerator.generate() >= MIN_MOVING_CONDITIONS) {
        true -> MoveState.GO
        else -> MoveState.STOP
    }

    companion object {
        private const val MIN_MOVING_CONDITIONS: Int = 4
    }
}
