package racingcar.model

object OnlyGoMoveStrategy : MoveStrategy {
    override val movedStatus: MovingStatus = MovingStatus.GO
}

object OnlyStopMoveStrategy : MoveStrategy {
    override val movedStatus: MovingStatus = MovingStatus.GO
}
