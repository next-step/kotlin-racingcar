package carracing.domain

fun interface MoveStrategy {
    fun isMovable(): Boolean
}
