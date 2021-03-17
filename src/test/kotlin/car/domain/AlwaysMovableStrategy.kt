package car.domain

class AlwaysMovableStrategy : MovableStrategy {
    override val movable: Boolean
        get() = true
}
