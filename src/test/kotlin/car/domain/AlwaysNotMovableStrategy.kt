package car.domain

class AlwaysNotMovableStrategy : MovableStrategy {
    override val movable: Boolean = false
}
