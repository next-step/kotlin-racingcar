package racingcar.domain.result

import racingcar.domain.car.Car
import java.lang.IllegalArgumentException

class CarRacingRoundResult private constructor(
    private val positionsByCarOrder: MutableMap<Int, Int>
) {
    fun record(cars: List<Car>) {
        cars.forEach { car ->
            positionsByCarOrder[car.order] = car.position
        }
    }

    fun getCarPosition(carOrder: Int): Int =
        positionsByCarOrder[carOrder] ?: throw IllegalArgumentException("기록된 자동차가 아닙니다")

    fun getCarPositionsInorder(): List<Int> =
        positionsByCarOrder.entries.sortedBy { it.key }.map { it.value }

    companion object {
        fun createInitialResult(cars: List<Car>): CarRacingRoundResult {
            val positionsByCarOrder = mutableMapOf<Int, Int>()
            cars.forEach { positionsByCarOrder[it.order] = it.position }
            return CarRacingRoundResult(positionsByCarOrder = positionsByCarOrder)
        }
    }
}
