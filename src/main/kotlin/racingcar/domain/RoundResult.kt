package racingcar.domain

import java.lang.IllegalArgumentException

class RoundResult private constructor(
    private val positionsByCarOrder: MutableMap<Int, Int>
) {
    fun record(cars: List<Car>) {
        cars.forEach { car ->
            positionsByCarOrder[car.order] = car.position
        }
    }

    fun getCarPosition(carOrder: Int): Int =
        positionsByCarOrder[carOrder] ?: throw IllegalArgumentException("기록된 자동차가 아닙니다")

    companion object {
        fun createInitialResult(configuration: RoundResultConfiguration): RoundResult {
            val positionsByCarOrder = mutableMapOf<Int, Int>()
            configuration.cars.forEach { positionsByCarOrder[it.order] = it.position }
            return RoundResult(positionsByCarOrder = positionsByCarOrder)
        }
    }
}
