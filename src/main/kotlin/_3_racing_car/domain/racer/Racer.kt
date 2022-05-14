package _3_racing_car.domain.racer

import _3_racing_car.domain.Position

abstract class Racer() {
    protected abstract val position: Position
    val location: Int
        get() = position.value

    abstract fun move(power: Int)
}
