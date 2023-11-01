package study.racingcar.domain

import study.racingcar.inteface.MoveStrategy
import study.racingcar.ui.ResultView

class Race private constructor(
    val cars: List<Car>,
    private val moveCount: Int,
    private val moveStrategy: MoveStrategy
) {
    init {
        require(cars.isNotEmpty()) { "자동차 대수는 1대 이상이어야 합니다." }
        require(moveCount > 0) { "시도할 횟수는 1회 이상이어야 합니다." }
    }

    fun run() {
        repeat(moveCount) {
            cars.forEach { car ->
                val shouldMove = moveStrategy.shouldMove()
                car.move(shouldMove)
            }
            ResultView.displayCars(cars)
        }
    }

    companion object {
        fun create(cars: List<Car>, moveCount: Int, moveStrategy: MoveStrategy): Race {
            return Race(cars, moveCount, moveStrategy)
        }
    }
}
