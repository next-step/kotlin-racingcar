package car.domain.move

class AlwaysNotMovableStrategy : MovableStrategy {
    override val movable: Boolean = false
}
