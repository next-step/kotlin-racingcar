package car_race.logic.car

import car_race.logic.system.MovingSystem

class Car(
    private val carName: CarName,
    private var carPosition: CarPosition = CarPosition()
) {
    fun getPosition() = carPosition

    fun getName() = carName.getName()

    fun getNameAndPosition(): Pair<CarName, CarPosition> {
        return carName to carPosition
    }

    fun nextRound(movingSystem: MovingSystem) {
        if (movingSystem.canMove()) {
            carPosition = carPosition.move(1)
        }
    }
}
