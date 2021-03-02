package racing.domain.movement

class GoForwardMoveStrategy : MoveStrategy {
    override val decisionNumber: Int
        get() = (4..9).random()
}
