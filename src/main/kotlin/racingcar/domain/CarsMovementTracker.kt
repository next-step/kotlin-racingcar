package racingcar.domain

import racingcar.domain.vo.CarPosition

class CarsMovementTracker(cars: List<Car>) {
    private val values: LinkedHashMap<Car, MutableList<CarPosition>> = LinkedHashMap()

    init {
        cars.forEach { car ->
            values[car] = mutableListOf(car.getUnmodifiablePosition())
        }
    }

    fun recordCarsPosition(car: Car) {
        val carPositionHistory = values[car] ?: throw IllegalArgumentException("해당하는 자동차가 없습니다.")
        carPositionHistory.add(car.getUnmodifiablePosition())
    }

    fun getCarsPositionHistories(): LinkedHashMap<Car, List<CarPosition>> {
        return values.mapValues { (_, positionHistory) ->
            positionHistory.toList()
        } as LinkedHashMap<Car, List<CarPosition>>
    }
}
