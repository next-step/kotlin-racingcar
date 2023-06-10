package racing.domain.formula

object NotMoveFormula : MoveFormula {

    override fun move(): MoveState = MoveState.STOP
}
