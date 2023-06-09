package step3.domain.formula

import step3.domain.generator.NumberGenerator

interface MoveFormula {

    fun move(): Boolean
}

class BasicRuleMoveFormula(private val numberGenerator: NumberGenerator) : MoveFormula {

    override fun move(): Boolean = numberGenerator.generate() >= MIN_MOVING_CONDITIONS

    companion object {
        private const val MIN_MOVING_CONDITIONS: Int = 4
    }
}
