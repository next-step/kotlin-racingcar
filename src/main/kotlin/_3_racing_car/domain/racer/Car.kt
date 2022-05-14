package _3_racing_car.domain.racer

import _3_racing_car.domain.Engine
import _3_racing_car.domain.Position

class Car(override val position: Position = Position(0)) : Racer() {
    override fun move(power: Int) = run {

        if (canMove(power)) {
            position.forward()
        }
    }

    private fun canMove(power: Int): Boolean = engine.canMoveEngine(power)

    companion object {
        val engine: Engine = Engine()
    }
}
