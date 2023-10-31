package racing.domain

class AlwaysMovingStrategy : MovingStrategy {
    override fun isMovable(): Boolean {
        return true
    }
}
