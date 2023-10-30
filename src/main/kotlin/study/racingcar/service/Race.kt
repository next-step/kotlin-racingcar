package study.racingcar.service

import study.racingcar.domain.Car
import study.racingcar.inteface.MoveStrategy
import study.racingcar.ui.ResultView

class Race private constructor(
    val cars: List<Car>,
    private val moveCount: Int,
    private val moveStrategy: MoveStrategy
) {

    companion object {
        fun createWithCarNames(carNames: List<String>, moveCount: Int, moveStrategy: MoveStrategy): Race {
            val cars = carNames.map { Car(it) }
            return Race(cars, moveCount, moveStrategy)
        }

        fun createWithCars(cars: List<Car>, moveCount: Int, moveStrategy: MoveStrategy): Race {
            return Race(cars, moveCount, moveStrategy)
        }
    }

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
}
