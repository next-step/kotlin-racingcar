package _3_racing_car.domain.racer

import _3_racing_car.domain.Name
import _3_racing_car.domain.Position

abstract class Racer() {
    abstract val name: Name
    protected abstract var position: Position

    abstract fun move(power: Int): Position
}
