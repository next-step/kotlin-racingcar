package racing.model

import racing.RandomMoving

class CarPositionHistory(private val carPositionHistory: LinkedHashMap<Car, PositionHistory>) {
    fun play() {
        carPositionHistory.forEach { (car, positionHistory) ->
            val position = car.move(RandomMoving)
            positionHistory.save(position)
        }
    }

    fun forEach(action: (Car, PositionHistory) -> Unit) = carPositionHistory.forEach(action)
}
