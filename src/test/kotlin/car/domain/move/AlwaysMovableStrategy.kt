package car.domain.move

import car.domain.move.MovableStrategy

class AlwaysMovableStrategy : MovableStrategy {
    override val movable: Boolean = true
}
