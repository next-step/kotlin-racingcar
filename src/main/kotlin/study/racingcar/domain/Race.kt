package study.racingcar.domain

import study.racingcar.dto.RacingCarState
import study.racingcar.inteface.MoveStrategy

class Race private constructor(
    val cars: List<Car>,
    private val moveCount: Int,
    private val moveStrategy: MoveStrategy
) {
    init {
        require(cars.isNotEmpty()) { "자동차 대수는 1대 이상이어야 합니다." }
        require(moveCount > 0) { "시도할 횟수는 1회 이상이어야 합니다." }
    }

    fun run(): List<RacingCarState> {
        val result = mutableListOf<RacingCarState>()
        repeat(moveCount) {
            cars.forEach { car ->
                val shouldMove = moveStrategy.shouldMove()
                car.move(shouldMove)
            }
            result.addAll(cars.map { RacingCarState(it.name.name, it.position) })
        }
        return result
    }

    companion object {
        fun create(cars: List<Car>, moveCount: Int, moveStrategy: MoveStrategy): Race {
            return Race(cars, moveCount, moveStrategy)
        }
    }
}
