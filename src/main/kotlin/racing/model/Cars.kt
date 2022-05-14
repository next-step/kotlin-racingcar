package racing.model

import racing.RandomMoving

class Cars(private val cars: List<Car>) {
    fun moveCars(): PositionHistory {
        val positionHistory = PositionHistory(mutableListOf())
        cars.forEach { car ->
            positionHistory.save(car.move(RandomMoving))
        }
        return positionHistory
    }
}
