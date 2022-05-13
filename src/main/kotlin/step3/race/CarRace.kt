package step3.race

import step3.car.Car

class CarRace {

    fun moveCarPosition(car: Car, canMoveForward: Boolean) {
        if (canMoveForward) {
            moveForward(car)
        }
    }

    private fun moveForward(car: Car) = car.moveCount++
}
