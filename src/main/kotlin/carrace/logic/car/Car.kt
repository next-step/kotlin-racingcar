package carrace.logic.car

import carrace.logic.system.MovingSystem

class Car(
    val carName: CarName,
    val carPosition: CarPosition = CarPosition()
) {
    fun nextRound(movingSystem: MovingSystem): Car {
        val movingDistance = movingDistance(movingSystem)
        return Car(
            this.carName,
            CarPosition(this.carPosition.position + movingDistance)
        )
    }

    private fun movingDistance(movingSystem: MovingSystem): Int {
        return if (movingSystem.canMove()) 1 else 0
    }
}
