package step3.domain.formula

object NotMoveFormula : MoveFormula {

    override fun move(value: Int): Boolean = false
}
