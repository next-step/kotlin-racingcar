package car.domain

class AlwaysMovableStrategy : MovableStrategy {
    override fun isMovable(): Boolean {
        return true
    }
}
