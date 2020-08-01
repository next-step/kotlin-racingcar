package step4.strategy

class UnconditionalMoveStrategy : MoveStrategy {
    override fun getResultOfTurn(): Int {
        return ConditionalMoveStrategy.SUCCESS_TO_MOVE
    }
}
