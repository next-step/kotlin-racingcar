package car_race.logic.car

import car_race.logic.system.MovingSystem

class Car(
    carName: CarName,
    carPosition: CarPosition = CarPosition()
) {
    val carName: CarName = carName

    var carPosition: CarPosition = carPosition
        private set

    fun nextRound(movingSystem: MovingSystem) {
        if (movingSystem.canMove()) {
            carPosition = carPosition.move(1)
        }
    }
}
