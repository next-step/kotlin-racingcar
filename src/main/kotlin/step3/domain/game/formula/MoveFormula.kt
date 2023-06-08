package step3.domain.game.formula

interface MoveFormula {

    fun move(value: Int): Boolean
}

class BasicRuleMoveFormula internal constructor() : MoveFormula {

    override fun move(value: Int): Boolean = value >= MIN_MOVING_CONDITIONS

    companion object {
        private const val MIN_MOVING_CONDITIONS: Int = 4
    }
}
