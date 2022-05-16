package racing.race

import racing.car.Car

class CarRace {

    fun moveCarPosition(car: Car) {
        moveForward(car)
    }

    private fun moveForward(car: Car) = car.moveCount++
}
