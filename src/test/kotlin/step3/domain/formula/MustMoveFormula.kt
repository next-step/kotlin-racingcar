package step3.domain.formula

import step3.domain.game.formula.MoveFormula

object MustMoveFormula : MoveFormula {

    override fun move(value: Int): Boolean = true
}
