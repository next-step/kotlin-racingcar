package racing.model

import racing.RandomMoving

class CarPositionHistory(private val carHistory: LinkedHashMap<Car, PositionHistory>) {
    fun savePosition() {
        carHistory.forEach { (car, positionHistory) ->
            car.savePosition(positionHistory)
        }
    }

    fun moveAllCars() {
        carHistory.keys.forEach { car ->
            car.move(RandomMoving)
        }
    }

    fun forEach(action: (Car, PositionHistory) -> Unit) = carHistory.forEach(action)
}
