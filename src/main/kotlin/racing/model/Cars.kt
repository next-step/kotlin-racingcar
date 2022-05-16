package racing.model

import racing.RandomMoving

class Cars(private val cars: List<Car>) {
    fun moveCars(): PositionHistory {
        val positionHistory = mutableListOf<CarMoveResult>()
        cars.forEach { car ->
            positionHistory.add(car.move(RandomMoving))
        }
        return PositionHistory(positionHistory.toList())
    }
}
