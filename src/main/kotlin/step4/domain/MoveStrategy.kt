package step4.domain

interface MoveStrategy {
    val count: Int
    fun isMoveSuccess(): Boolean
}
