package step3.domain.formula

interface MoveFormula {

    fun move(value: Int): Boolean
}

object BasicRuleMoveFormula : MoveFormula {

    private const val MIN_MOVING_CONDITIONS: Int = 4

    override fun move(value: Int): Boolean = value >= MIN_MOVING_CONDITIONS
}
