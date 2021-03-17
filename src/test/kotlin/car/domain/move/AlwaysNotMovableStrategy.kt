package car.domain.move

import car.domain.move.MovableStrategy

class AlwaysNotMovableStrategy : MovableStrategy {
    override val movable: Boolean = false
}
