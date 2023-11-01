package study.racing.strategy

interface MoveStrategy {
    fun isMoving(): Boolean

    fun isMoving(
        carIndex: Int,
        roundIndex: Int,
    ): Boolean
}
