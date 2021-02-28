package racing.domain.movement

class StopMoveStrategy : MoveStrategy {
    override val decisionNumber: Int
        get() = (0..3).random()
}
