package _3_racing_car.domain.racer

import _3_racing_car.domain.Engine
import _3_racing_car.domain.Name
import _3_racing_car.domain.Position

class Car(override val name: Name = Name("알수없음"), override var position: Position = Position(0)) : Racer() {

    override fun move(power: Int): Position {
        if (canMove(power)) {
            this.position = position.forward()
        }
        return this.position
    }

    private fun canMove(power: Int): Boolean = engine.canMoveEngine(power)

    companion object {
        val engine: Engine = Engine()
    }
}
