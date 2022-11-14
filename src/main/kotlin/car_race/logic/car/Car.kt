package car_race.logic.car

import car_race.logic.system.MovingSystem

class Car(
    private var carPosition: CarPosition = CarPosition()
) {
    fun getPosition(): CarPosition {
        return carPosition
    }

    fun nextRound(movingSystem: MovingSystem) {
        if (movingSystem.canMove()) {
            carPosition = carPosition.move(1)
        }
    }
}
