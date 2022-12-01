package carrace.logic.car

import carrace.logic.system.MovingSystem

class Car(
    val carName: CarName,
) {
    var carPosition: CarPosition = CarPosition()
        private set

    fun nextRound(movingSystem: MovingSystem): CarInfo {
        carPosition = carPosition.move(movingDistance(movingSystem))

        return CarInfo(
            carName, carPosition
        )
    }

    private fun movingDistance(movingSystem: MovingSystem): Int {
        return if (movingSystem.canMove()) 1 else 0
    }
}
