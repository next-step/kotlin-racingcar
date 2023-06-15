package racing.domain

fun interface MovePolicy {
    fun isMovable(): Boolean
}
