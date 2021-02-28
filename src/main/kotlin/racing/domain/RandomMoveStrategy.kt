package racing.domain

class RandomMoveStrategy : MoveStrategy {
    override val decisionNumber: Int
        get() = (0..9).random()
}