package carracing.domain

interface MoveStrategy {
    fun isMovable(): Boolean
}
